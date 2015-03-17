package test;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Iterator;

import beans.Element;
import beans.Menu;
import beans.Utilisateur;

import rmi.DatabaseInterface;

public class Client {

	/**
	 * @param args
	 * @throws NotBoundException 
	 * @throws RemoteException 
	 * @throws MalformedURLException 
	 */
	public static void main(String[] args) throws MalformedURLException, RemoteException, NotBoundException {
		String nomService = "rmi://localhost:1099/Database";
		DatabaseInterface obj = (DatabaseInterface) Naming.lookup(nomService);

//		Authentifier un utilisateur
//		
//		Utilisateur u = new Utilisateur();
//		u.setNomUtilisateur("bernardog");
//		u.setMotPasse("12345");
//		u.setEstAdmin(false);
//		boolean b = obj.authentifierAdmin(u);
//		System.out.println(b);
//		u.setMotPasse("123");
//		u.setEstAdmin(true);
//		b = obj.authentifierAdmin(u);
//		System.out.println(b);
		
//		
		ArrayList<Menu> menus = obj.getMenus();
		for(Menu m : menus) {
			System.out.println(m.getNom());
			for(Element el : m.getElements()) {
				System.out.println(el.getNom());
			}
		}
		
	}

}
