package rmi;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

import beans.Menu;
import beans.Utilisateur;

public interface DatabaseInterface extends Remote {

	public boolean authentifierAdmin(Utilisateur utilisateur) throws RemoteException;

	public ArrayList<Menu> getMenus() throws RemoteException;
	
}
