package presentacion;

import logica.Circulo;
import logica.Figura;
import logica.Triangulo;

public class Principal {
	
	public static void main(String[] args) {
		mostrarFigura(new Triangulo("amarillo", 4.2, 8.3));
		mostrarFigura(new Circulo("azul", 3.5));
	}

	private static void mostrarFigura(Figura figura) {
		System.out.println("Color: " + figura.getColor());
		System.out.println("Superficie: " + figura.calcularSuperficie());
	}
}
