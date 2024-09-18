package logica;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import model.Pieza;

public class GestionPiezas {
	private Set<Pieza> piezas;
	
	public GestionPiezas() {
		piezas = new HashSet<>();
	}
	
	public void agregarPieza(String nombre, Date fechaFabricacion) {
		piezas.add(new Pieza(nombre, fechaFabricacion));
	}
	
	public void agregarPieza(String nombre) {
		piezas.add(new Pieza(nombre, new Date()));
	}
	
	public Set<Pieza> obtenerPiezasAntiguas(Date fecha) {
		Set<Pieza> piezasAntiguas = new HashSet<>();
		for(Pieza pieza: piezas) {
			if(pieza.getFechaFabricacion().getTime() < fecha.getTime())
				piezasAntiguas.add(pieza);
		}
		return piezasAntiguas;
	}
}
