package server.common;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface DossierSuivi extends Remote{
	
	
	DossierSuivi getDossierSuivi() throws RemoteException ;
	void modify(String s, String sa) throws RemoteException ;

}
