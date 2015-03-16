package database;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import beans.Utilisateur;

public class UtilisateurDAO extends BaseDonnees {
	
	public void create(Utilisateur utilisateur) throws SQLException {
		String sql = null;
		sql += "INSERT INTO utilisateur ";
		sql += "(username, motpasse) ";
		sql += "values (?, ?)";
		open();
		PreparedStatement ps = co.prepareStatement(sql);
		ps.setString(1, utilisateur.getNomUtilisateur());
		ps.setString(2, utilisateur.getMotPasse());
		ps.executeUpdate();
		close();
	}
	
	public boolean authentifierUtilisateur(Utilisateur utilisateur) throws SQLException {
		String sql = null;
		sql += "SELECT * FROM utilisateur WHERE ";
		sql += "username=? AND ";
		sql += "motPasse=?";
		open();
		PreparedStatement ps = co.prepareStatement(sql);
		ps.setString(1,  utilisateur.getNomUtilisateur());
		ps.setString(2, utilisateur.getMotPasse());
		ResultSet rs = ps.executeQuery();
		return rs.next();
	}
	
	public boolean authentifierAdministrateur(Utilisateur utilisateur) throws SQLException {
		String sql = null;
		sql += "SELECT * FROM utilisateur WHERE ";
		sql += "username=? AND ";
		sql += "motPasse=? AND ";
		sql += "admin=true";
		open();
		PreparedStatement ps = co.prepareStatement(sql);
		ps.setString(1,  utilisateur.getNomUtilisateur());
		ps.setString(2, utilisateur.getMotPasse());
		ResultSet rs = ps.executeQuery();
		return rs.next();
	}

}
