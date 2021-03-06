package server.classes;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;

import server.common.Animal;
import server.common.CabinetVeto;

public class CabinetVetoImpl extends UnicastRemoteObject implements CabinetVeto{

	List<Animal> list;
	
	public CabinetVetoImpl() throws RemoteException {
		super();
		list = new ArrayList<>();
	}

	@Override
	public List<Animal> getPatients() throws RemoteException  {
		return list;
	}
	
	public List<Animal> add(Animal pat) throws RemoteException  {
		list.add(pat);
		return list;
	}

	@Override
	public List<Animal> add(String nom, String maitre, int agemoyen, String nomEspece, String jsp)
			throws RemoteException {
		Animal an = new AnimalImpl(nom, maitre, new EspeceImpl(agemoyen, nomEspece), jsp);
		list.add(an);		
		return list;
	}
	
	@Override
	public Animal get(String name) throws RemoteException  {
		for (Animal animal : list) {
			if (animal.getNom().equals(name)) {
				return animal;
			}
		}
		return null;
	}
}
