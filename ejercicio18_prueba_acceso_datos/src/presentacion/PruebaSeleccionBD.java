package presentacion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class PruebaSeleccionBD {

	public static void main(String[] args) {
		String url = "jdbc:mysql://localhost:3306/prueba";
		String username = "root";
		String password = "root";
		
		try(Connection con = DriverManager.getConnection(url, username, password)) {
			String sql = "SELECT * FROM personas";
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);
			while(rs.next())
				System.out.println(rs.getString("nombre") + " - " + rs.getInt("edad"));
		}
		catch(SQLException ex) {
			ex.printStackTrace();
		}

	}

}
