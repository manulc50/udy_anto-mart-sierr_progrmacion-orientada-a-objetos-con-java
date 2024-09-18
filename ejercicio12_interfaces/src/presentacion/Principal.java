package presentacion;

import auxiliar.Proceso;
import logica.Circulo;
import varios.Mesa;

public class Principal {

	public static void main(String... args) {
		procesar(new Circulo("verde", 4.3f));
		procesar(new Mesa(15.40f, 34.25f));
	}
	
	private static void procesar(Proceso proceso) {
		proceso.aumentar(9);
		proceso.imprimir();
		proceso.firmar();
	}
}
