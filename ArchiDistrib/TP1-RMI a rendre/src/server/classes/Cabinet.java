package server.classes;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;

import server.Server;
import server.common.IAnimal;
import server.common.ICabinet;

public class Cabinet extends UnicastRemoteObject implements ICabinet{

	private List<IAnimal> liste ;
	private Server instance;
	public Cabinet(Server s) throws RemoteException {
		super();
		liste = new ArrayList<IAnimal>();
		instance=s;
	}
	@Override
	public List<IAnimal> getPatients() throws RemoteException {
		return liste;
	}
	@Override
	public IAnimal get(String name) throws RemoteException {
		for (IAnimal a : liste) {
			if (a.getNom().equalsIgnoreCase(name)) {
				return a;
			}
		}
		return null;
	}
	@Override
	public void add(String n, String m, String e, String r) throws RemoteException {
		IAnimal a = new Animal(n, m, e, r);
		liste.add(a);
		instance.notifyAllClients("Un Animal à été ajouté");
	}
}
