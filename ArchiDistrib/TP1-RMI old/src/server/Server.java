package server;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.ArrayList;

import client.Client;
import server.classes.AnimalImpl;
import server.classes.CabinetVetoImpl;
import server.classes.EspeceImpl;
import server.classes.ObserverImpl;


public class Server {

	public static void main(String args[]) {
		try {
			/*
			 if (System.getSecurityManager() == null) {
			        System.setSecurityManager(new SecurityManager());
			        System.setProperty("java.security.Policy", "prop.policy");
			 }
			 */
			 
			CabinetVetoImpl vet = new CabinetVetoImpl();
			ObserverImpl obs = new ObserverImpl();
			
			
			AnimalImpl obj = new AnimalImpl("Roget", "Blandine", new EspeceImpl(12, "a"), "b");
			vet.add(obj);
			obs.notifyALl("Animal ajouté");

			AnimalImpl obj1 = new AnimalImpl("Pierrick", "Blandine", new EspeceImpl(15, "z"), "g");
			vet.add(obj1);
			obs.notifyALl("Animal ajouté");
			
			AnimalImpl obj2 = new AnimalImpl("Gustave", "Lamantine", new EspeceImpl(15, "z"), "g");
			vet.add(obj2);
			obs.notifyALl("Animal ajouté");
			
			AnimalImpl obj3 = new AnimalImpl("Chaussette", "Gustave", new EspeceImpl(15, "z"), "g");
			vet.add(obj3);
			obs.notifyALl("Animal ajouté");
			
			Registry registry = LocateRegistry.createRegistry(1099);
			//Registry registry = LocateRegistry.getRegistry();
			if (registry==null){
				System.err.println("RmiRegistry not found");
			}else{
				//registry.bind("Animal", obj);
				//registry.rebind("Animal", obj);
				registry.rebind("Cabinet", vet);
				registry.rebind("Observer", obs);
				System.out.println("Server ready");
			}
		} catch (Exception e) {
			System.err.println("Server exception: " + e.toString());
			e.printStackTrace();
		}
	}
}
