package server.classes;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import server.common.Animal;
import server.common.DossierSuivi;
import server.common.Espece;

public class AnimalImpl extends UnicastRemoteObject implements Animal{
	private String nom;
	private String maitre;
	private Espece espece;
	private String race;
	private DossierSuivi dossier;
	
	public AnimalImpl(String nom, String maitre, Espece espece, String race) throws RemoteException {
		super();	
		this.nom = nom;
		this.maitre = maitre;
		this.espece = espece;
		this.race = race;
		dossier = new DossierSuiviImpl();
	}
	@Override
	public String getNom() throws RemoteException {
		//System.out.println("Nom : " + nom);
		return nom;
	}
	@Override
	public String getNomMaitre() throws RemoteException {
		//System.out.println("Nom du maitre : " + maitre);
		return maitre;
	}
	@Override
	public Espece getEspece() throws RemoteException {
		//System.out.println("Espece : " + espece);
		return espece;
	}
	@Override
	public String getRace() throws RemoteException {
		//System.out.println("Race : " + race);
		return race;
	}
	@Override
	public DossierSuivi getDossierSuivi() throws RemoteException  {
		return dossier;
	}
}
