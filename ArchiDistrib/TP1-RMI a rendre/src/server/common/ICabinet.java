package server.common;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

public interface ICabinet extends Remote{
	
	public List<IAnimal> getPatients() throws RemoteException ;
	public IAnimal get(String name) throws RemoteException ;
	public void add(String n, String m, String e, String r) throws RemoteException ;
}
