package server.classes;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import server.common.Espece;

public class EspeceImpl extends UnicastRemoteObject implements Espece{

	private int age;
	private String name;
	public EspeceImpl(int a, String n) throws RemoteException {
		super();
		age = a;
		name = n;
	}

	@Override
	public int getAgeMoy() throws RemoteException {
		return age;
	}

	@Override
	public String label() throws RemoteException {
		return name;
	}

}
