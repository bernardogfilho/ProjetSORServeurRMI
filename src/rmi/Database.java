package rmi;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.SQLException;

import database.UtilisateurDAO;

import beans.Utilisateur;

public class Database extends UnicastRemoteObject implements DatabaseInterface {


	protected Database() throws RemoteException {
	}

	public boolean authentifierAdmin(Utilisateur utilisateur)
			throws RemoteException {
		UtilisateurDAO dao = new UtilisateurDAO();
		try {
			return dao.authentifierAdmin(utilisateur);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;	
	}

}
