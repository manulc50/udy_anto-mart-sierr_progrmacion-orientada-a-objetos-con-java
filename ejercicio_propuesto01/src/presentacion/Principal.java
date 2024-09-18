package presentacion;

import java.text.ParseException;
import java.util.Date;
import java.util.Scanner;

import logica.GestionPedidos;
import modelo.Pedido;

public class Principal {

	public static void main(String[] args) {
		GestionPedidos gestionPedidos = new GestionPedidos();
		Scanner sc = new Scanner(System.in);
		int opcion = 0;
		while(opcion != 5) {
			System.out.println("1 - Nuevo pedido");
			System.out.println("2 - Pedido mayor");
			System.out.println("3 - Total facturado");
			System.out.println("4 - Pedidos entre fechas");
			System.out.println("5 - Salir");
			System.out.println("Introduce una opción:");
			opcion = Integer.parseInt(sc.nextLine());
			switch(opcion) {
				case 1:
					System.out.println("Introduce el producto:");
					String producto = sc.nextLine();
					System.out.println("Introduce el precio del producto:");
					double precio = Double.parseDouble(sc.nextLine());
					System.out.println("Introduce el número de unidades:");
					int unidades = Integer.parseInt(sc.nextLine());
					Date fecha = solicitarFecha(sc, "Introduce la fecha del pedido(yyyy-MM-dd):");
					gestionPedidos.agregar(producto, precio, unidades, fecha);
					break;
				case 2:
					Pedido pedido = gestionPedidos.obtenerMayorUnidades();
					if(pedido == null)
						System.out.println("No hay pedidos registrados");
					else
						System.out.println("Producto: " + pedido.getProducto() + ", precio: " + pedido.getPrecioUnitario() +
								", unidades: " + pedido.getUnidades() + ", fecha: " + GestionPedidos.SDF.format(pedido.getFecha()));
					break;
				case 3: 
					System.out.println("Total facturado: " + gestionPedidos.calcularTotalFacturado());
					break;
				case 4:
					Date fecha1 = solicitarFecha(sc, "Introduce la fecha inicial(yyyy-MM-dd):");
					Date fecha2 = solicitarFecha(sc, "Introduce la fecha final(yyyy-MM-dd):");
					for(Pedido p: gestionPedidos.obtenerPedidos(fecha1, fecha2))
						System.out.println("Producto: " + p.getProducto() + ", precio: " + p.getPrecioUnitario() + ", unidades: " + p.getUnidades() + ", fecha: " + GestionPedidos.SDF.format(p.getFecha()));
					break;
				case 5:
					sc.close();
					break;
				default:
					System.out.println("Opción inválida");
					break;
			}
		}
	}
	
	private static Date solicitarFecha(Scanner sc, String mensaje) {
		Date fecha = null;
		try {
			System.out.println(mensaje);
			fecha = GestionPedidos.SDF.parse(sc.nextLine());
		}
		catch (ParseException e) {
			e.printStackTrace();
		}
		return fecha;
	}
	
}
