package client;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Notifiable extends Remote{

    void notify(String msg) throws RemoteException;
}
