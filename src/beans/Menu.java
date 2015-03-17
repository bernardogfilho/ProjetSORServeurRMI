package beans;

import java.io.Serializable;
import java.sql.Date;
import java.util.ArrayList;

public class Menu implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -2788397587018152169L;
	private int id;
	private String nom;
	private Date expiration;
	private ArrayList<Element> elements;
	
	public Menu() {
		elements = new ArrayList<Element>();
	}
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getNom() {
		return nom;
	}
	
	public void setNom(String nom) {
		this.nom = nom;
	}
	
	public Date getExpiration() {
		return expiration;
	}
	
	public void setExpiration(Date expiration) {
		this.expiration = expiration;
	}

	public ArrayList<Element> getElements() {
		return elements;
	}

	public void setElements(ArrayList<Element> elements) {
		this.elements = elements;
	}
	
	public void addElement(Element el) {
		elements.add(el);
	}
	
}
