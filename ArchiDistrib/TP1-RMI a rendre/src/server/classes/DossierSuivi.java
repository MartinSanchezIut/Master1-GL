package server.classes;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import server.common.IDossierSuivi;

public class DossierSuivi extends UnicastRemoteObject implements IDossierSuivi{

	private String dossier;
	public DossierSuivi() throws RemoteException {
		super();
		dossier = "";
	}
	@Override
	public String getInfo() throws RemoteException{
		return dossier;
	}
	@Override
	public IDossierSuivi getDossier() throws RemoteException{
		return this;
	}
	@Override
	public void modifier(String s) throws RemoteException{
		dossier +=  s + " \n ";
	}

}
