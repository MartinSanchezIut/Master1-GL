package server;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import client.Notifiable;
import client.Observer;
import server.classes.Animal;
import server.classes.Cabinet;
import server.common.IAnimal;
import server.common.ICabinet;

public class Server extends UnicastRemoteObject implements Observer{
	
	private static ArrayList<Notifiable> l ;
	public Server() throws RemoteException {
		super();
		l = new ArrayList<>();
	}
	@Override
	public void addClient(Notifiable n) throws RemoteException{
		l.add(n);		
	}
	public void notifyAllClients(String msg) throws RemoteException {
		for(Notifiable n : l) {
			n.notify(msg);
		}
	}
	
	public void init(String[] args) {
		try {	
			/* if (System.getSecurityManager() == null) {
			        System.setProperty("java.security.Policy", "file:./prop.policy");
			        System.setSecurityManager(new SecurityManager());
			 }*/
			
			// Ex 4:
	        //System.setProperty("java.rmi.server.codebase", "file:/home/e20180002097/Bureau/Master/ArchiDistrib/TP1-RMI/bin");

			 
			// Ex1:
			IAnimal cat = new Animal("Zizoo", "Martin", "Chat","Domestique");
			
			// Ex2:
			ICabinet cab = new Cabinet(this);
			cab.getPatients().add(cat);
			cab.getPatients().add(new Animal("Fitou", "Vic", "Chien","Simplet"));
			cab.getPatients().add(new Animal("Milou", "Tintin", "Chien","Aventurier"));
			cab.getPatients().add(new Animal("Animal1", "Maitre1", "Chien","De la casse"));
			cab.getPatients().add(new Animal("Animal2", "Maitre1", "Loup","Solitaire"));
			cab.getPatients().add(new Animal("Animal3", "Maitre2", "Poisson","Rouge"));
			notifyAllClients("Animaux ajoutés");
			
			Registry registry = LocateRegistry.createRegistry(1099);
			//Registry registry = LocateRegistry.getRegistry();
			if (registry==null){
				System.err.println("RmiRegistry not found");
			}else{
				//registry.bind("Animal", obj);
				//registry.rebind("Animal", obj);
				registry.rebind("server", this);
				registry.rebind("Zizoo", cat);
				registry.rebind("Cabinet", cab);
				System.out.println("Server ready");
			}
		} catch (Exception e) {
			System.err.println("Server exception: " + e.toString());
			e.printStackTrace();
		}
	}

	public static void main(String args[]) throws RemoteException {
		Server s = new Server();
		s.init(args);
	}
}
