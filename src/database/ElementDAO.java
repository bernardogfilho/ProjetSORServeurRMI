package database;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import beans.Element;

public class ElementDAO extends BaseDonnees {
	
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
