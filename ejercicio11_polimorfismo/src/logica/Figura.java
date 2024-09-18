package logica;

public abstract class Figura {
	private String color;

	public Figura(String color) {
		this.color = color;
	}
	
	public abstract double calcularSuperficie();
	
	public String getColor() {
		return color;
	}
}
