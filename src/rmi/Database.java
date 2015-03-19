package rmi;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.SQLException;
import java.util.ArrayList;

import database.ElementDAO;
import database.MenuDAO;
import database.UtilisateurDAO;

import beans.Element;
import beans.Menu;
import beans.Utilisateur;

public class Database extends UnicastRemoteObject implements DatabaseInterface {


	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

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

    public byte[] getImage(String id) throws RemoteException, SQLException {
        ElementDAO dao = new ElementDAO();
        return dao.getImage(id);
    }

    public void createUtilisateur(Utilisateur u) throws RemoteException, SQLException {
        UtilisateurDAO dao = new UtilisateurDAO();
        dao.create(u, false);
    }

    public boolean authentifier(Utilisateur u) throws RemoteException {
        UtilisateurDAO dao = new UtilisateurDAO();
        try {
            return dao.authentifierUtilisateur(u);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

	public void createElement(Element e) throws RemoteException {
		ElementDAO dao = new ElementDAO();
		try {
			dao.create(e);
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
	}

	public void destroyElement(int id) throws RemoteException {
		ElementDAO dao = new ElementDAO();
		try {
			dao.destroy(id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public ArrayList<Element> findElementByType(String type)
			throws RemoteException {
		ElementDAO dao = new ElementDAO();
		try {
			return dao.findByType(type);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public void createMenu(Menu m) throws RemoteException {
		MenuDAO dao = new MenuDAO();
		try {
			dao.createMenu(m);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

}
