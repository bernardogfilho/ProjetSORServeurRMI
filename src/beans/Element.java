package beans;

import java.io.Serializable;

public class Element implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2807114773011561552L;
	private int id;
	private String nom;
	private String type;
	private byte[] image;
	
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
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
    public byte[] getImage() {
        return image;
    }
    public void setImage(byte[] image) {
        this.image = image;
    }
}
