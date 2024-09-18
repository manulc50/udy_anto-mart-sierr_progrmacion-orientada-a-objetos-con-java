package logica;

import auxiliar.Proceso;

public class Circulo extends Figura implements Proceso {
	private float radio;
	
	public Circulo(String color, float radio) {
		super(color);
		this.radio = radio;
	}

	@Override
	public double calcularSuperficie() {
		return Math.PI * radio * radio;
	}

	@Override
	public void imprimir() {
		System.out.println("El radio es " + radio);
		
	}

	@Override
	public void aumentar(float cantidad) {
		radio += cantidad;
		
	}

}
