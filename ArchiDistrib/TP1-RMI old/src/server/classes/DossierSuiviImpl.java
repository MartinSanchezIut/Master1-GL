package server.classes;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import server.common.DossierSuivi;

public class DossierSuiviImpl extends UnicastRemoteObject implements DossierSuivi{

	private String s;
	private String sa;
	public DossierSuiviImpl() throws RemoteException {
		super();
	}

	@Override
	public DossierSuivi getDossierSuivi() throws RemoteException  {
		System.out.println("Envoie du dossier");
		return this;
	}

	@Override
	public void modify(String s, String sa) throws RemoteException {
		this.s = s;
		this.sa = sa;
		System.out.println("Modif du dossier " + s + "  " + sa);
	}
}