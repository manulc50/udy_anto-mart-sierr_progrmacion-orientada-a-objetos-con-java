package logica;

public class ProductoEstandar extends Producto {
	private String seccion;
	
	public ProductoEstandar(String nombre, double precio, String seccion) {
		super(nombre, precio);
		this.seccion = seccion;
	}
	
	@Override
	public double obtenerPrecioPedido(int unidades) {
		double precio = super.obtenerPrecioPedido(unidades);
		if(unidades >= 5)
			return  precio - precio * 0.1;
		return precio;
	}

	public String getSeccion() {
		return seccion;
	}

	public void setSeccion(String seccion) {
		this.seccion = seccion;
	}
	
}
