package server;

import java.util.Collections;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

import remote.ClientInterface;

public class Manager implements Iterable<ClientInterface>{
	// need a set to track all clients
	private Set<ClientInterface> clientsList;
	
	public Manager(Server server) {
	
		// to use ConcurrentHashMap, we can deal with when two client draw on the same place at the same time
		this.clientsList = Collections.newSetFromMap(new ConcurrentHashMap<ClientInterface, Boolean>());
		}
	
	// this function can add a client to the client list
	public void addClient(ClientInterface client) {
		this.clientsList.add(client);
	}
	
	// get client list
	public Set<ClientInterface> getClientList(){
		return this.clientsList;
	}
	
//	// check the size of the set
//	public boolean isEmpty() {
//		if(this.clientsList.size()==0) {
//			return true;
//		}
//		return false;
//	}
	
	// remove the client from the set
	public void deleteClient(ClientInterface client) {
		this.clientsList.remove(client);
	}
	


	// to use iterator we can use loop to go through each element in the set
	// reference https://www.w3schools.com/java/java_iterator.asp
	@Override
	public Iterator<ClientInterface> iterator() {
		// TODO Auto-generated method stub
		return clientsList.iterator();
	}
}
