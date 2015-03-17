package rmi;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.SQLException;
import java.util.ArrayList;

import database.MenuDAO;
import database.UtilisateurDAO;

import beans.Menu;
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

	public ArrayList<Menu> getMenus() throws RemoteException {
		MenuDAO dao = new MenuDAO();
		try {
			return dao.findAll();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	

}
