package presentacion;

import java.text.DateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import logica.GestionPiezas;
import model.Pieza;

public class Principal {

	public static void main(String[] args) {
		GestionPiezas gestionPiezas = new GestionPiezas();
		Scanner sc = new Scanner(System.in);
		int opcion = 0;
		while(opcion != 3) {
			System.out.println("1 - Añadir pieza");
			System.out.println("2 - Mostrar piezas antiguas");
			System.out.println("3 - Salir");
			System.out.println("Introduce una opción:");
			opcion = Integer.parseInt(sc.nextLine());
			switch(opcion) {
				case 1: {
					System.out.println("Introduce el nombre de la pieza:");
					String nombre = sc.nextLine();
					Date fechaFabricacion = solicitarFechaFabricacion(sc);
					gestionPiezas.agregarPieza(nombre, fechaFabricacion);
					break;
				}
				case 2: {
					Date fechaFabricacion = solicitarFechaFabricacion(sc);
					DateFormat dateFormat = DateFormat.getDateInstance(DateFormat.FULL, new Locale("ES", "es"));
					for(Pieza pieza: gestionPiezas.obtenerPiezasAntiguas(fechaFabricacion))
						System.out.println("Nombre: " + pieza.getNombre() + ", fecha de fabricación: " + dateFormat.format(pieza.getFechaFabricacion()));
					break;
				}
				case 3:
					sc.close();
					break;
				default:
					System.out.println("Opción inválida");
					break;
			}
		}
	}
	
	private static Date solicitarFechaFabricacion(Scanner sc) {
		System.out.println("Introduce el año de fabricación de la pieza:");
		int anio = Integer.parseInt(sc.nextLine());
		System.out.println("Introduce el mes(1-12) de fabricación de la pieza:");
		int mes = Integer.parseInt(sc.nextLine());
		System.out.println("Introduce el día de fabricación de la pieza:");
		int dia = Integer.parseInt(sc.nextLine());
		Calendar calendario = Calendar.getInstance();
		// -1 porque en Calendar los meses se identifican desde el 0 hasta el 11
		calendario.set(anio, mes - 1, dia);
		return calendario.getTime();
	}

}
