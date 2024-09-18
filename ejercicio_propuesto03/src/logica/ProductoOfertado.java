package logica;

public class ProductoOfertado extends Producto {
	private int dias;

	public ProductoOfertado(String nombre, double precio, int dias) {
		super(nombre, precio);
		this.dias = dias;
	}
	
	@Override
	public double obtenerPrecioPedido(int unidades) {
		double precio = super.obtenerPrecioPedido(unidades);
		switch(dias) {
			case 1:
				return precio - precio * 0.2;
			case 2:
			case 3:
				return precio - precio * 0.15;
			default:
				return precio - precio * 0.1;
		}
	}

	public int getDias() {
		return dias;
	}

	public void setDias(int dias) {
		this.dias = dias;
	}
	
}
