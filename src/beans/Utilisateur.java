package beans;

public class Utilisateur {
	
	private int id;
	private String nomUtilisateur;
	private String motPasse;
	private boolean estAdmin;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNomUtilisateur() {
		return nomUtilisateur;
	}
	public void setNomUtilisateur(String nomUtilisateur) {
		this.nomUtilisateur = nomUtilisateur;
	}
	public String getMotPasse() {
		return motPasse;
	}
	public void setMotPasse(String motPasse) {
		this.motPasse = motPasse;
	}
	public boolean isEstAdmin() {
		return estAdmin;
	}
	public void setEstAdmin(boolean estAdmin) {
		this.estAdmin = estAdmin;
	}
	
	

}
