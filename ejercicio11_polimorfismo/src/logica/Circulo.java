package logica;

public class Circulo extends Figura {
	private double radio;
	
	public Circulo(String color, double radio) {
		super(color);
		this.radio = radio;
	}

	@Override
	public double calcularSuperficie() {
		return Math.PI * radio * radio;
	}

}
