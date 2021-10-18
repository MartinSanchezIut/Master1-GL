package server.common;

import java.rmi.Remote;
import java.rmi.RemoteException;

import client.Client;

public interface DistributedObserver extends Remote {
	
	void addClient(Client client) throws RemoteException ;
	void notifyALl(String text) throws RemoteException ;

}
