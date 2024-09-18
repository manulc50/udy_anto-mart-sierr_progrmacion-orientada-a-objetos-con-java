package model;

import java.util.Date;

public class Pieza {
	private String nombre;
	private Date fechaFabricacion;
	
	public Pieza(String nombre, Date fechaFabricacion) {
		this.nombre = nombre;
		this.fechaFabricacion = fechaFabricacion;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Date getFechaFabricacion() {
		return fechaFabricacion;
	}

	public void setFechaFabricacion(Date fechaFabricacion) {
		this.fechaFabricacion = fechaFabricacion;
	}
	
}
