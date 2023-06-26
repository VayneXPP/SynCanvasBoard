package server;

import java.io.IOException;
import java.io.Serializable;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.Set;

import remote.ClientInterface;
import remote.CommunicationInterface;
import remote.ServerInterface;

public class Server extends UnicastRemoteObject implements ServerInterface, Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Manager clientManager;
	
	protected Server() throws RemoteException{
		this.clientManager = new Manager(this);
	}

	@Override
	public void addNewUser(ClientInterface client) throws RemoteException {
		// TODO Auto-generated method stub
		Boolean accessible = true;
		System.out.print("addUser function invoked");
		// first we need to check if this client is the 1st one, because 1st one will be the manager
		if(this.clientManager.getClientList().size() == 0) {
			client.setToManager();
		}
		
		// find manager and handle the new client join in accessible
		for(ClientInterface canvasClientInterface: this.clientManager) {
			if (canvasClientInterface.getManager()) {
				try {
					accessible = canvasClientInterface.sendJoinRequest(client.getName());
				} catch (Exception e) {
					// TODO: handle exception
					e.printStackTrace();
				}			
			}
		}
		
		
		if (!accessible) {
			try {
				client.approveJoinRequest(accessible);
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}
		
		if (client.getManager()) {
			try {
				client.setName(client.getName() + "(Manager)");
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}
		
		// add manager can add this new client 
		this.clientManager.addClient(client);
		
		// update all client's client list that has a new one joined in 
		for(ClientInterface canvasClientInterface : this.clientManager) {
			canvasClientInterface.updateUserList(getClientList());
		}
		
	}
	
	@Override
	public void clientLeave(String name) throws RemoteException {
		// TODO Auto-generated method stub
		for(ClientInterface canvasClientInterface:this.clientManager) {
			if (canvasClientInterface.getName().equals(name)) {
				this.clientManager.deleteClient(canvasClientInterface);
			}
		}
		for(ClientInterface canvasClientInterface:this.clientManager) {
			canvasClientInterface.updateUserList(getClientList());
		}
		
	}

	@Override
	public void kickClient(String selectName) throws IOException {
		// TODO Auto-generated method stub
		for(ClientInterface canvasClientInterface:this.clientManager) {
			if(canvasClientInterface.getName().equals(selectName)) {
				this.clientManager.deleteClient(canvasClientInterface);
				canvasClientInterface.exitCanvas();
			}
		}
		
	}

	@Override
	public void kickAllClient() throws IOException {
		// TODO Auto-generated method stub
		for(ClientInterface canvasClientInterface:this.clientManager) {
			this.clientManager.deleteClient(canvasClientInterface);
			canvasClientInterface.exitCanvas();
		}
		
	}

	@Override
	public Set<ClientInterface> getClientList() throws RemoteException {
		// TODO Auto-generated method stub
		return this.clientManager.getClientList();
	}

	@Override
	public void broadCastCanvas(CommunicationInterface canvasMsgInterface) throws RemoteException {
		// TODO Auto-generated method stub
		for(ClientInterface canvasClientInterface : this.clientManager) {
			canvasClientInterface.syncCanvas(canvasMsgInterface);
		}
	}
	
	@Override
	public void updateChat(String text) throws RemoteException {
		// TODO Auto-generated method stub
		for(ClientInterface canvasClientInterface:this.clientManager) {
			try {
				canvasClientInterface.updateChat(text);
			} catch (RemoteException e) {
				// TODO: handle exception
			}
		}
		
	}

	@Override
	public byte[] syncToManagerCanvas() throws IOException {
		// TODO Auto-generated method stub
		byte[] currImage = null;
		for(ClientInterface canvasClientInterface:this.clientManager) {
			if (canvasClientInterface.getManager()) {
				currImage = canvasClientInterface.sendCurCanvas();
			}
		}
		return currImage;
	}

	@Override
	public void syncToOpenedCanvas(byte[] rawImage) throws IOException {
		// TODO Auto-generated method stub
		for(ClientInterface canvasClientInterface:this.clientManager) {
			if (canvasClientInterface.getManager()== false) {
				canvasClientInterface.syncToOpened(rawImage);
			}
		}
		
	}

	@Override
	public void clearAllCanvas() throws RemoteException {
		// TODO Auto-generated method stub
		for(ClientInterface canvasClientInterface : this.clientManager) {
			canvasClientInterface.refreshCanvas();
		}
	}
	


}
