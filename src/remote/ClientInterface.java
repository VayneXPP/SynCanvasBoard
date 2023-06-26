package remote;

import java.io.IOException;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.Set;

public interface ClientInterface extends Remote{
	public void drawBoard(ServerInterface serverInterface) throws RemoteException;
	// update client list
	public void updateUserList(Set<ClientInterface> clientList)throws RemoteException;
	
	// broadcast change to all clients
	public void syncCanvas(CommunicationInterface message) throws RemoteException;
	
	// if new client want to join in, ask manage to agree
	public boolean sendJoinRequest(String name)throws IOException;
	
	//get to client name
	public String getName() throws RemoteException;
	
	public boolean getApprovement()throws IOException;
	
	// if there is a manager
	public boolean getManager()throws RemoteException;
	

	public void setName(String name)throws RemoteException;
	
	public void approveJoinRequest(boolean permission)throws IOException;
	
	// set this client to manager
	public void setToManager() throws RemoteException;

	
	// update chat box content
	public void updateChat(String text) throws RemoteException;
	
	// send manager's canvas to the new client and cover his canvas
	public byte[] sendCurCanvas()throws IOException, RemoteException;
	
	// manager can open a saved canvas and sends it to all client to cover
	public void syncToOpened(byte[] rawImage)throws IOException;
	
	public void refreshCanvas()throws RemoteException;
	
	// close canvas
	public void exitCanvas() throws IOException;
	

}
