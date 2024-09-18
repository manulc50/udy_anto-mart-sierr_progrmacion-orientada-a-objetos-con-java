package modelo;

public class Empleado {
	private String nombre;
	private String email;
	private int edad;
	private String departamento;
	private double salario;
	
	public Empleado(String nombre, String email, int edad, String departamento, double salario) {
		this.nombre = nombre;
		this.email = email;
		this.edad = edad;
		this.departamento = departamento;
		this.salario = salario;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public String getDepartamento() {
		return departamento;
	}

	public void setDepartamento(String departamento) {
		this.departamento = departamento;
	}

	public double getSalario() {
		return salario;
	}

	public void setSalario(double salario) {
		this.salario = salario;
	}

}
