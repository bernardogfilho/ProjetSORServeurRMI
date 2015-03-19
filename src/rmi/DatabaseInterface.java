package rmi;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.sql.SQLException;
import java.util.ArrayList;

import beans.Element;
import beans.Menu;
import beans.Utilisateur;

public interface DatabaseInterface extends Remote {

	public boolean authentifierAdmin(Utilisateur utilisateur) throws RemoteException;

	public ArrayList<Menu> getMenus() throws RemoteException;

    public byte[] getImage(String id) throws RemoteException, SQLException;

    public void createUtilisateur(Utilisateur u) throws RemoteException, SQLException;

    public boolean authentifier(Utilisateur u) throws RemoteException;
    
    public void createElement(Element e) throws RemoteException;
	
    public void destroyElement(int id) throws RemoteException;
}
