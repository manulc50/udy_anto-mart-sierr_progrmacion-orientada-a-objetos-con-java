package logica;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

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
		return agenda.values().stream()
				.filter(contacto -> contacto.getEdad() <= edad)
				.toArray(tam -> new Contacto[tam]);
	}
	
	public boolean existeContacto(String nombre) {
		return agenda.values().stream()
				.anyMatch(contacto -> contacto.getNombre() == nombre);
	}
	
	public Contacto obtenerContactoConMayorEdad() {
		return agenda.values().stream()
				.max((contacto1, contacto2) -> contacto1.getEdad() - contacto2.getEdad())
				.orElse(null);
	}
	
	public Contacto buscarPorNombre(String nombre) {
		return agenda.values().stream()
				.filter(contacto -> contacto.getNombre().equals(nombre))
				.findFirst()
				.orElse(null);
	}
	
	public List<String> obtenerNombres() {
		return agenda.values().stream()
				.map(contacto -> contacto.getNombre())
				.collect(Collectors.toList());
	}
	
	public double calcularEdadMedia() {
		return agenda.values().stream()
				.mapToInt(contacto -> contacto.getEdad())
				.average()
				.getAsDouble();
	}
}
