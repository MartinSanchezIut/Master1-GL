package server.common;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import server.classes.AnimalImpl;
import server.classes.EspeceImpl;

public interface CabinetVeto extends Remote{
	
	List<Animal> getPatients() throws RemoteException ;
	Animal get(String name) throws RemoteException ;
	List<Animal> add(String nom, String maitre, int agemoyen, String nomEspece, String jsp) throws RemoteException ;
}
