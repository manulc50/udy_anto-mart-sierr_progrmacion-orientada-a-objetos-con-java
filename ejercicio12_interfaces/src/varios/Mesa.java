package varios;

import auxiliar.Proceso;

public class Mesa implements Proceso {
	private float ancho, largo;
	
	public Mesa(float ancho, float largo) {
		this.ancho = ancho;
		this.largo = largo;
	}

	@Override
	public void imprimir() {
		System.out.println("El largo es " + largo + " y el ancho es " + ancho);

	}

	@Override
	public void aumentar(float cantidad) {
		ancho += cantidad;
		largo += cantidad;
	}

}
