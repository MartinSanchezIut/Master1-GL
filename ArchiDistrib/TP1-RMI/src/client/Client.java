package client;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import server.classes.DossierSuiviImpl;
import server.common.Animal;
import server.common.CabinetVeto;
import server.common.DossierSuivi;
import server.common.Espece;

public class Client {
	
	public static void main(String[] args) {

		String host = (args.length < 1) ? null : args[0];
		try {
			Registry registry = LocateRegistry.getRegistry(host);
			
			CabinetVeto stub = (CabinetVeto) registry.lookup("Cabinet");
			
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
}