package database;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import beans.Utilisateur;

public class UtilisateurDAO extends BaseDonnees {
	
	public void create(Utilisateur utilisateur, boolean admin) throws SQLException {
		String sql = "";
		sql += "INSERT INTO utilisateur ";
		sql += "(username, motpasse, admin) ";
		sql += "VALUES (?, ?, ?)";
		open();
		PreparedStatement ps = co.prepareStatement(sql);
		ps.setString(1, utilisateur.getNomUtilisateur());
		ps.setString(2, utilisateur.getMotPasse());
		ps.setBoolean(3, admin);
		System.out.println("EXECUTING QUERY: "+ps);
		ps.executeUpdate();
		close();
	}
	
	public boolean authentifierUtilisateur(Utilisateur utilisateur) {
		String sql = "";
		sql += "SELECT * FROM utilisateur WHERE ";
		sql += "username=? AND ";
		sql += "motPasse=?";
		open();
        try {
            PreparedStatement ps = co.prepareStatement(sql);
            ps.setString(1,  utilisateur.getNomUtilisateur());
            ps.setString(2, utilisateur.getMotPasse());
            ResultSet rs = ps.executeQuery();
            return rs.next();
        } catch(Exception e) {
            e.printStackTrace();
            return false;
        }
	}
	
	public boolean authentifierAdmin(Utilisateur utilisateur) throws SQLException {
		String sql = "";
		sql += "SELECT * FROM utilisateur WHERE ";
		sql += "username=? AND ";
		sql += "motPasse=? AND ";
		sql += "admin=true";
		open();
		PreparedStatement ps = co.prepareStatement(sql);
		System.out.println(ps);
		ps.setString(1,  utilisateur.getNomUtilisateur());
		ps.setString(2, utilisateur.getMotPasse());
		ResultSet rs = ps.executeQuery();
		return rs.next();
	}

}
