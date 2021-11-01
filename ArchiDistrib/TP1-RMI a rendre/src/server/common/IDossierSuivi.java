package server.common;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface IDossierSuivi extends Remote{
	
	public String getInfo() throws RemoteException ;
	public IDossierSuivi getDossier() throws RemoteException ;
	public void modifier(String s) throws RemoteException ;
}
