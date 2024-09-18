package presentacion;

import java.util.ArrayList;
import java.util.List;

import logica.Producto;
import logica.ProductoEstandar;
import logica.ProductoOfertado;

public class Principal {

	public static void main(String[] args) {
		List<Producto> productos = new ArrayList<>();
		productos.add(new ProductoEstandar("estandar 1", 10, "alimentación"));
		productos.add(new ProductoEstandar("estandar 2", 20, "deportes"));
		productos.add(new ProductoOfertado("ofertado 1", 10, 2));
		productos.add(new ProductoOfertado("ofertado 2", 20, 2));
		productos.add(new ProductoOfertado("ofertado 3", 30, 2));
		
		double precioTotal = 0;
		for(Producto producto: productos)
			precioTotal += producto.obtenerPrecioPedido(5);
		System.out.println("Precio total de los pedidos: " + precioTotal);
	}
}
