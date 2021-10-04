package server;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import client.ObjectInCodebase;
import server.classes.AnimalImpl;
import server.classes.CabinetVetoImpl;
import server.classes.EspeceImpl;


public class Server {

	
	public static void main(String args[]) {
		try {
	        System.setProperty("java.rmi.server.codebase", "file:/home/e20180002097/Bureau/Master/ArchiDistrib/TP1-RMI/bin");

	        //System.setProperty("java.security.Policy", "prop.policy");
	        
/*			 if (System.getSecurityManager() == null) {
			        System.setSecurityManager(new SecurityManager());
			 }*/
			 
	        ObjectInCodebase o = new ObjectInCodebase();
	        
			 
			CabinetVetoImpl vet = new CabinetVetoImpl();
			
			AnimalImpl obj = new AnimalImpl("Roget", "Blandine", new EspeceImpl(12, "a"), "b");
			vet.add(obj);

			AnimalImpl obj1 = new AnimalImpl("Pierrick", "Blandine", new EspeceImpl(15, "z"), "g");
			vet.add(obj1);
			
			AnimalImpl obj2 = new AnimalImpl("Gustave", "Lamantine", new EspeceImpl(15, "z"), "g");
			vet.add(obj2);
			
			AnimalImpl obj3 = new AnimalImpl("Chaussette", "Gustave", new EspeceImpl(15, "z"), "g");
			vet.add(obj3);
			
			Registry registry = LocateRegistry.createRegistry(1099);
			//Registry registry = LocateRegistry.getRegistry();
			if (registry==null){
				System.err.println("RmiRegistry not found");
			}else{
				//registry.bind("Animal", obj);
				//registry.rebind("Animal", obj);
				registry.rebind("Cabinet", vet);
				System.out.println("Server ready");
			}
		} catch (Exception e) {
			System.err.println("Server exception: " + e.toString());
			e.printStackTrace();
		}
	}
}
