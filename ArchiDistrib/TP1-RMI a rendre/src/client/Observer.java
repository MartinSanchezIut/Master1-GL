package client;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Observer extends Remote{
	
	public void addClient(Notifiable n) throws RemoteException;
}
