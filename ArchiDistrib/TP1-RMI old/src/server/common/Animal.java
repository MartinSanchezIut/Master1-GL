package server.common;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Animal extends Remote{

	String getNom() throws RemoteException;
	String getNomMaitre() throws RemoteException;
	Espece getEspece() throws RemoteException;
	String getRace() throws RemoteException;
	
	DossierSuivi getDossierSuivi() throws RemoteException ;
	
}
