package remote;

import java.io.IOException;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.Set;

public interface ServerInterface extends Remote{
	
	// if new client connects
	public void addNewUser(ClientInterface client) throws RemoteException;
	
	// if has client leaves, update client list for all client
	public void clientLeave(String name) throws RemoteException;
	
	// manager kick some one out 
	public void kickClient(String selectName) throws IOException;
	
	// when manager leaves, kick all client
	public void kickAllClient() throws IOException;
	
	// a list of all current clients connected to the server
	public Set<ClientInterface> getClientList() throws RemoteException;
	
	// if anyone make change on the canvas, broadcast to all clients
	public void broadCastCanvas(CommunicationInterface communicationInterface) throws RemoteException;
	
	// update chat box
	public void updateChat(String text) throws RemoteException;
	
	// when manager already drawn many shapes, new client connects in, package manager's canvas as image and cover on new client's empty canvas
	public byte[] syncToManagerCanvas() throws IOException; 
	
	// if open a image, cover this image to all clients
	public void syncToOpenedCanvas(byte[] rawImage) throws IOException;
	
	// manager clear all canvas
	public void clearAllCanvas() throws RemoteException;

}
