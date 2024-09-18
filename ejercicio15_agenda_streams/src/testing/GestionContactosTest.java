package testing;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import logica.GestionContactos;

class GestionContactosTest {
	static GestionContactos gestionContactos; 

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		gestionContactos = new GestionContactos();
		gestionContactos.agregar("c1", "c1@email.com", 10);
		gestionContactos.agregar("c2", "c2@email.com", 20);
		gestionContactos.agregar("c3", "c3@email.com", 30);
		gestionContactos.agregar("c4", "c4@email.com", 40);
	}

	@Test
	void testExisteContacto() {
		assertTrue(gestionContactos.existeContacto("c1"));
		assertFalse(gestionContactos.existeContacto("c5"));
	}

	@Test
	void testObtenerContactoConMayorEdad() {
		assertEquals("c4", gestionContactos.obtenerContactoConMayorEdad().getNombre());
	}

	@Test
	void testBuscarPorNombre() {
		assertNotNull(gestionContactos.buscarPorNombre("c2"));
		assertNull(gestionContactos.buscarPorNombre("c5"));
	}

	@Test
	void testObtenerNombres() {
		assertEquals(4, gestionContactos.obtenerNombres().size());
	}

	@Test
	void testCalcularEdadMedia() {
		assertEquals(25, gestionContactos.calcularEdadMedia());
	}

}
