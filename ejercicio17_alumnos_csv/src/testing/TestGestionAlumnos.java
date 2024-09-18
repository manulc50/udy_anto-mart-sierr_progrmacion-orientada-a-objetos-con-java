package testing;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import logica.GestionAlumnos;

class TestGestionAlumnos {
	static GestionAlumnos gestionAlumnos;

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		gestionAlumnos = new GestionAlumnos();
	}

	@Test
	void testCalcularNotaMediaPorCurso() {
		assertEquals(6.75, gestionAlumnos.calcularNotaMediaPorCurso("Java"));
		assertEquals(6.5, gestionAlumnos.calcularNotaMediaPorCurso("Python"), 0.1);
	}

	@Test
	void testObtenerAlumnosPorCurso() {
		assertEquals(3, gestionAlumnos.obtenerAlumnosPorCurso("Python").size());
		assertEquals(0, gestionAlumnos.obtenerAlumnosPorCurso("Angular").size());
	}

	@Test
	void testObtenerAlumnoConNotaMasAlta() {
		assertEquals("a3", gestionAlumnos.obtenerAlumnoConNotaMasAlta().getNombre());
	}

	@Test
	void testObtenerNombreCursos() {
		assertEquals(3, gestionAlumnos.obtenerNombreCursos().size());
	}

}
