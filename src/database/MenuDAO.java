package database;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import beans.Element;
import beans.Menu;

public class MenuDAO extends BaseDonnees{

	public ArrayList<Menu> findAll() throws SQLException {
		ArrayList<Menu> menus = new ArrayList<Menu>();
		String sql = "";
		sql += "SELECT * FROM menu";
		open();
		PreparedStatement ps = co.prepareStatement(sql);
		System.out.println("EXECUTING QUERY: " + ps);
		ResultSet rs = ps.executeQuery();
		while(rs.next()) {
			Menu menu = new Menu();
			menu.setNom(rs.getString("nom"));
			menu.setExpiration(rs.getDate("expiration"));
			menu.setId(rs.getInt("id"));
			addElements(menu);
			menus.add(menu);
		}
		close();
		return menus;
	}
	
	private void addElements(Menu m) throws SQLException {
		String sql = "SELECT el.nom, el.image, el.type ";
		sql += "FROM (Menu m ";
		sql += "LEFT JOIN menus_elements mel ";
		sql += "ON m.id = mel.menu_id) ";
		sql += "LEFT JOIN element el ";
		sql += "ON mel.element_id = el.id ";
		sql += "WHERE m.id = ?";
		PreparedStatement ps = co.prepareStatement(sql);
		ps.setInt(1, m.getId());
		ResultSet rs = ps.executeQuery();
		while(rs.next()) {
			Element el = new Element();
			el.setNom(rs.getString("nom"));
			el.setImage(rs.getBlob("image"));
			el.setType(rs.getString("type"));
			m.addElement(el);
		}
	}
	
}
