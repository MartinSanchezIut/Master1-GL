package server.common;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Espece extends Remote{
	
	int getAgeMoy() throws RemoteException ;
	String label() throws RemoteException ;
}
