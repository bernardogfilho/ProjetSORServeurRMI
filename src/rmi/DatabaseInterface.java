package rmi;

import java.rmi.Remote;
import java.rmi.RemoteException;

import beans.Utilisateur;

public interface DatabaseInterface extends Remote {

	public boolean authentifierAdmin(Utilisateur utilisateur) throws RemoteException;

}
