package server.classes;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

import client.Client;
import server.common.DistributedObserver;

public class ObserverImpl extends UnicastRemoteObject implements DistributedObserver{
	
	public ArrayList<Client> listCli;

	public ObserverImpl() throws RemoteException {
		super();
		listCli =  new ArrayList<>();
	}
	@Override
	public void addClient(Client client)  throws RemoteException {
		listCli.add(client);
	}
	@Override
	public void notifyALl(String text) throws RemoteException {
		for(Client c : listCli) {
			c.notify(text);
		}
		
	}
	
	

}
