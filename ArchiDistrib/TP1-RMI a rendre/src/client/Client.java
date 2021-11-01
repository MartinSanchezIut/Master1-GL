package client;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

import server.common.IAnimal;
import server.common.ICabinet;


public class Client extends UnicastRemoteObject implements Notifiable{
	
	public Client() throws RemoteException {
		super();
	}
	public void init(String[] args) {
		String host = (args.length < 1) ? null : args[0];
		try {
			Registry registry = LocateRegistry.getRegistry(host);
			
			// Ex 5:
			Observer s = (Observer) registry.lookup("server");
			s.addClient(this);

			// Ex1:
			IAnimal stub = (IAnimal) registry.lookup("Zizoo");
			String response = stub.getNom();
			System.out.println("response: " + response);
			System.out.println(stub.getDossier().getInfo());
			stub.getDossier().modifier("Test");
			System.out.println(stub.getDossier().getInfo());
			System.out.println(stub.getEspece());
			System.out.println(stub.getRace());

			// Ex2: 
			ICabinet cabinet = (ICabinet) registry.lookup("Cabinet");
			for (IAnimal a : cabinet.getPatients()) {
				System.out.print(a.getNom() + " ");
			}
			System.out.println(" ");
			IAnimal zizoo = cabinet.get("Zizoo");
			System.out.println(zizoo.getNom() + " " + zizoo.getMaitre());
			cabinet.add("Ajout", "Test", "Je sais pas", "Peu importe");
			for (IAnimal a : cabinet.getPatients()) {
				System.out.print(a.getNom() + " ");
			}
			System.out.println(" ");
					
			
		} catch (Exception e) {
			System.err.println("Client exception: " + e.toString());

			e.printStackTrace();
		}
	}
	@Override
	public void notify(String msg) throws RemoteException{
		System.out.println("Notif : " + msg);
	}

	public static void main(String[] args) throws RemoteException {		
		Client c = new Client();
		c.init(args);
	}
}
