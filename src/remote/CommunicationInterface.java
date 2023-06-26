package remote;

import java.awt.Color;
import java.awt.Point;
import java.rmi.Remote;
import java.rmi.RemoteException;

public interface CommunicationInterface extends Remote{
	
	// to get the client name who just send chat
	public String getName()throws RemoteException;
	
	//to get the color of current drawn
	public Color getColor()throws RemoteException;
	
	// to get the new drawn start or drawing or end from client
	public String getState()throws RemoteException;
	
	// to get the points of current drawn
	public Point getPoint()throws RemoteException;
	
//	// to get the end point of current drawn
//	public String endPoint()throws RuntimeException;

	// to get the chat content the client sent
	public String getText()throws RemoteException;
	
	
	// to get what shape current drawn is 
	public String getMode()throws RemoteException;

}
