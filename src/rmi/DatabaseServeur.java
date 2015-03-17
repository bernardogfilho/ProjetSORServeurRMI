package rmi;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.server.UnicastRemoteObject;
import java.sql.SQLException;

import beans.Utilisateur;
import database.UtilisateurDAO;

public class DatabaseServeur {
	
	public static void main(String[] args) throws RemoteException, MalformedURLException {
		Database db = new Database();
		UtilisateurDAO dao = new UtilisateurDAO();
		Utilisateur u = new Utilisateur();
		u.setMotPasse("123");
		u.setNomUtilisateur("bernardog");
		try {
			dao.create(u, true);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		LocateRegistry.createRegistry(1099);
		Naming.rebind("rmi://localhost:1099/Database", db);
		System.out.println("The server is ready.");
	}
}
