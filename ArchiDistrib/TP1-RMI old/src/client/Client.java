package client;

import java.io.Serializable;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import server.classes.DossierSuiviImpl;
import server.common.Animal;
import server.common.CabinetVeto;
import server.common.DistributedObserver;
import server.common.DossierSuivi;
import server.common.Espece;

// Lien pour le truc https://homepage.univie.ac.at/peter.brezany/teach/01WS-sweng/RMI-slides1.pdf

public class Client implements Notifiable{
	
	public void init(String[] args) {
		ObjectInCodebase o = new ObjectInCodebase();
		
		String host = (args.length < 1) ? null : args[0];
		try {
			Registry registry = LocateRegistry.getRegistry(host);
			
			CabinetVeto stub = (CabinetVeto) registry.lookup("Cabinet");
			DistributedObserver observer = (DistributedObserver) registry.lookup("Observer");
			observer.addClient(this);
			
			
			stub.add("Jeannot", "Pierro", 15, "Coucou", "salope du biff");
			Animal gustave = stub.get("Gustave");
			System.out.println(gustave.getNom());
			
			Animal jeanot = stub.get("Jeannot");
			System.out.println(jeanot.getNom());
			
			/*
			Animal stub = (Animal) registry.lookup("Animal");
			String response = stub.getNom();
			System.out.println("response: " + response);
			
			DossierSuivi doss = stub.getDossierSuivi();
			System.out.println("response: " + doss);
			
			stub.getDossierSuivi().modify("nana", "nini");
			
			DossierSuivi doss1 = stub.getDossierSuivi();
			System.out.println("response: " + doss1);
			
			Espece esp = stub.getEspece();
			System.out.println("response: " + esp.getAgeMoy() + " " + esp.label());			
			*/
		} catch (Exception e) {
			System.err.println("Client exception: " + e.toString());

			e.printStackTrace();
		}
	}
	
	public void notify(String text) {
		System.out.println("Client : " + text);
	}
	
	
	public static void main(String[] args) {
		Client c = new Client(); 
		c.init(args);
	}
}
