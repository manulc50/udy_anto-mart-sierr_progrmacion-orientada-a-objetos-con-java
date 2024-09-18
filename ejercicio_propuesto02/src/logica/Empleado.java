package logica;

import java.time.LocalDate;

public abstract class Empleado {
	protected final static double BONO = 5.75; 
	
	private String nombre;
	private int edad;
	private LocalDate fechaIngreso;
	private double salario;
	
	public Empleado(String nombre, int edad, LocalDate fechaIngreso, double salario) {
		this.nombre = nombre;
		this.edad = edad;
		this.fechaIngreso = fechaIngreso;
		this.salario = salario;
	}

	public abstract void incentivar();

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public LocalDate getFechaIngreso() {
		return fechaIngreso;
	}

	public void setFechaIngreso(LocalDate fechaIngreso) {
		this.fechaIngreso = fechaIngreso;
	}

	public double getSalario() {
		return salario;
	}

	public void setSalario(double salario) {
		this.salario = salario;
	}

}
