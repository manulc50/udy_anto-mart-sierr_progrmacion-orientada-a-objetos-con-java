package modelo;

public class Alumno {
	private String nombre;
	private String curso;
	private float nota;
	
	public Alumno(String nombre, String curso, float nota) {
		this.nombre = nombre;
		this.curso = curso;
		this.nota = nota;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getCurso() {
		return curso;
	}

	public void setCurso(String curso) {
		this.curso = curso;
	}

	public float getNota() {
		return nota;
	}

	public void setNota(float nota) {
		this.nota = nota;
	}
	
}
