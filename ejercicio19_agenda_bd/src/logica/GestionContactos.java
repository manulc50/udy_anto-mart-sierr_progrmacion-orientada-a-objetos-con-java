package logica;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import modelo.Contacto;

public class GestionContactos {
	private final static String URL = "jdbc:mysql://localhost:3306/agenda";
	private final static String USER = "root";
	private final static String PWD = "root";
	
	public boolean agregar(String nombre, String email, int edad) {
		if(buscar(email) != null)
			return false;
		try(Connection cn = DriverManager.getConnection(URL, USER, PWD)) {
			String sql = "INSERT INTO contactos(nombre, email, edad) VALUES(?, ?, ?)";
			PreparedStatement ps = cn.prepareStatement(sql);
			ps.setString(1, nombre);
			ps.setString(2, email);
			ps.setInt(3, edad);
			ps.execute();
			return true;
		}
		catch(SQLException ex) {
			ex.printStackTrace();
			return false;
		}
	}

	public Contacto buscar(String email) {
		Contacto contacto = null;
		try(Connection cn = DriverManager.getConnection(URL, USER, PWD)) {
			String sql = "SELECT * FROM contactos WHERE email = ?";
			PreparedStatement ps = cn.prepareStatement(sql);
			ps.setString(1, email);
			ResultSet rs = ps.executeQuery();
			// En este caso, como mucho solo puede haber un resultado
			if(rs.next())
				contacto = new Contacto(rs.getString("nombre"), rs.getString("email") ,rs.getInt("edad"));
		}
		catch(SQLException ex) {
			ex.printStackTrace();
		}
		return contacto;
	}
	
	public boolean eliminar(String email) {
		try(Connection cn = DriverManager.getConnection(URL, USER, PWD)) {
			String sql = "DELETE FROM contactos WHERE email = ?";
			PreparedStatement ps = cn.prepareStatement(sql);
			ps.setString(1, email);
			return ps.executeUpdate() == 1;
		}
		catch(SQLException ex) {
			ex.printStackTrace();
			return false;
		}
	}
	
	public List<Contacto> obtenerTodos() {
		List<Contacto> contactos = new ArrayList<>();
		try(Connection cn = DriverManager.getConnection(URL, USER, PWD)) {
			String sql = "SELECT * FROM contactos";
			Statement st = cn.createStatement();
			ResultSet rs = st.executeQuery(sql);
			while(rs.next())
				contactos.add(new Contacto(rs.getString("nombre"), rs.getString("email") ,rs.getInt("edad")));
		}
		catch(SQLException ex) {
			ex.printStackTrace();
		}
		return contactos;
	}
	
	public List<Contacto> obtenerPorEdadMaxima(int edad) {
		List<Contacto> contactos = new ArrayList<>();
		try(Connection cn = DriverManager.getConnection(URL, USER, PWD)) {
			String sql = "SELECT * FROM contactos WHERE edad <= ?";
			PreparedStatement ps = cn.prepareStatement(sql);
			ps.setInt(1, edad);
			ResultSet rs = ps.executeQuery();
			while(rs.next())
				contactos.add(new Contacto(rs.getString("nombre"), rs.getString("email") ,rs.getInt("edad")));
		}
		catch(SQLException ex) {
			ex.printStackTrace();
		}
		return contactos;
	}
}
