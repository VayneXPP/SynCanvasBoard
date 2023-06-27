/*
 * Start RMI
 * This version will start server in localhost aotomatically
 * if need change please add arg condition here
 */
package server;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import javax.swing.JOptionPane;

import remote.ServerInterface;

public class ServerDriver {

	public static void main(String args[]) {
//		if(args.length != 2) {
//			System.out.print("The format is not valid, please use the format <hostName> <port>.");
//			return;
//		}
		
		try {
			ServerInterface canvasServerInterface = new Server();
			
			Registry registry = LocateRegistry.createRegistry(Integer.parseInt("1234"));
			registry.bind("WhiteBoardServer", canvasServerInterface);
			// create registry and give name and bind
//			Registry registry = LocateRegistry.createRegistry(Integer.parseInt(args[1]));
//			registry.bind("WhiteBoardServer", canvasServerInterface);
			JOptionPane.showMessageDialog(null, "Server starting, please shut down when you finish.");
			System.out.print("server is running...");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			System.out.print("Current port is in use");
			System.exit(0);
		}
		
	}
}
