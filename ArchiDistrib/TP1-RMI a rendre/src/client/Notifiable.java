package client;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Notifiable extends Remote{
	
	public void notify(String msg) throws RemoteException;
}
