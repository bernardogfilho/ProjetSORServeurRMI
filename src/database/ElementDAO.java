package database;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import beans.Element;

public class ElementDAO extends BaseDonnees {
	
	public void create(Element e) throws SQLException{
		String sql = "INSERT INTO element ";
		sql += "(nom, type, image) ";
		sql += "VALUES (?, ?, ?)";
		open();
		PreparedStatement ps = co.prepareStatement(sql);
		System.out.println("CREATING ELEMENT... " + ps);
		ps.setString(1, e.getNom());
		ps.setString(2, e.getType());
		ps.setBytes(3, e.getImage());
		ps.executeUpdate();
		ps.close();
	}
	
	public void destroy(int id) throws SQLException {
		String sql = "DELETE FROM element WHERE id=?";
		open();
		PreparedStatement ps = co.prepareStatement(sql);
		ps.setInt(1, id);
		ps.executeUpdate();
		close();
	}
	
	public ArrayList<Element> findAll() throws SQLException {
	    ArrayList<Element> elements = new ArrayList<Element>();
        String sql = "";
        sql += "SELECT * FROM element";
        open();
        PreparedStatement ps = co.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            Element e = new Element();
            e.setImage(rs.getBytes("image"));
            e.setNom(rs.getString("nom"));
            e.setType(rs.getString("type"));
            elements.add(e);
        }
        close();
        return elements;
	}
	
	public ArrayList<Element> findByType(String type) throws SQLException {
		String sql =  "SELECT nom, id FROM element WHERE type=?";
		open();
		PreparedStatement ps = co.prepareStatement(sql);
		ps.setString(1, type);
		System.out.println("FIND BY TYPE: " + ps);
		ResultSet rs = ps.executeQuery();
		ArrayList<Element> elements = new ArrayList<Element>();
		while(rs.next()) {
			Element e = new Element();
			e.setId(rs.getInt("id"));
			e.setNom(rs.getString("nom"));
			elements.add(e);
		}
		return elements;
	}

    public byte[] getImage(String id) throws SQLException {
        String sql = "SELECT image FROM element WHERE id=?";
        open();
        PreparedStatement ps = co.prepareStatement(sql);
        ps.setString(1, id);
        System.out.println("EXECUTING QUERY: " + ps);
        ResultSet rs = ps.executeQuery();
        rs.next();
        byte[] images = rs.getBytes("image");
        return images;
    }

}
