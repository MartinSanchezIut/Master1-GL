package server.classes;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import server.common.IAnimal;
import server.common.IDossierSuivi;

public class Animal extends UnicastRemoteObject implements IAnimal{
	
	private String nom;
	private String maitre;
	private Espece espece;
	private IDossierSuivi dossier;

	public Animal(String n, String m, String e, String r) throws RemoteException {
		super();
		nom = n;
		maitre = m;
		espece = new Espece(e, r, Math.random() * ( 100 - 12 ));
		dossier = new DossierSuivi() ;
	}

	@Override
	public String getNom() throws RemoteException {
		return nom;
	}
	@Override
	public String getMaitre() throws RemoteException {
		return maitre;
	}
	@Override
	public String getEspece() throws RemoteException {
		return espece.getEspece() + " (" + espece.getDDV() + " ans) " ;
	}
	@Override
	public String getRace() throws RemoteException {
		return espece.getRace();
	}
	@Override
	public IDossierSuivi getDossier() throws RemoteException {
		return dossier;
	}

}
