package logica;

import java.util.HashMap;
import java.util.Map;

import modelo.Contacto;

public class GestionContactos {
	private Map<String, Contacto> agenda = new HashMap<>();
	
	public boolean agregar(String nombre, String email, int edad) {
		if(!agenda.containsKey(email)) {
			agenda.put(email, new Contacto(nombre, email, edad));
			return true;
		}
		return false;
	}
	
	public Contacto buscar(String email) {
		return agenda.get(email);
	}
	
	public boolean eliminar(String email) {
		if(agenda.containsKey(email)) {
			agenda.remove(email);
			return true;
		}
		return false;
	}
	
	public Contacto[] obtenerContactos() {
		return agenda.values().toArray(new Contacto[0]);
	}
}
