package server.common;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface IAnimal extends Remote{
	
	public String getNom() throws RemoteException;
	public String getMaitre() throws RemoteException;
	public String getEspece() throws RemoteException;
	public String getRace() throws RemoteException;
	
	public IDossierSuivi getDossier() throws RemoteException ;
}
