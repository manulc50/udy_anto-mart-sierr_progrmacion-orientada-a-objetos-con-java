package presentacion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class PruebaInsercionBD {

	public static void main(String... args) {
		String url = "jdbc:mysql://localhost:3306/prueba";
		String username = "root";
		String password = "root";
		
		try(Connection con = DriverManager.getConnection(url, username, password)) {
			String sql = "INSERT INTO personas(nombre, edad, email, altura) " +
					"VALUES('prueba3', 45, 'prueba3@email.com', 1.77)";
			Statement st = con.createStatement();
			st.execute(sql);
			System.out.println("Persona añadida!");
		}
		catch(SQLException ex) {
			ex.printStackTrace();
		}
	}
}
