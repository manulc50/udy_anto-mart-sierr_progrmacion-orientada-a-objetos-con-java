package logica;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
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
	
	public Contacto[] obtenerContactorPorEdadMaxima(int edad) {
		List<Contacto> contactos = new ArrayList<>();
		// Este método "forEach" recibe una implementación de la interfaz BiConsumer que es una interfaz funcional.
		// Por lo tanto, puede ser implementada con una función lambda.
		agenda.forEach((email, contacto) -> {
			if(contacto.getEdad() <= edad)
				contactos.add(contacto);
		});
		return contactos.toArray(new Contacto[0]);
	}
}
