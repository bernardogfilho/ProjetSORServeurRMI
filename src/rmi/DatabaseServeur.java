package rmi;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RMISecurityManager;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.sql.SQLException;

import beans.Utilisateur;
import database.UtilisateurDAO;

public class DatabaseServeur {
	
	public static void main(String[] args) throws RemoteException, MalformedURLException {
//		System.setSecurityManager(new RMISecurityManager());
        Database db = new Database();
		LocateRegistry.createRegistry(1099);
		Naming.rebind("rmi://localhost:1099/Database", db);
		System.out.println("The server is ready.");
	}
}
