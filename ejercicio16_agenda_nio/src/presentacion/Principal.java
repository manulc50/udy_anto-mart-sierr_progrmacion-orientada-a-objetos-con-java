package presentacion;

import java.util.Scanner;

import logica.GestionContactos;
import modelo.Contacto;

public class Principal {
	
	public static void main(String... args) {
		GestionContactos gestionContactos = new GestionContactos();
		Scanner sc = new Scanner(System.in);
		int opcion = 0;
		while(opcion != 5) {
			System.out.println("1 - Añadir contacto");
			System.out.println("2 - Buscar contacto");
			System.out.println("3 - Eliminar contacto");
			System.out.println("4 - Mostrar contactos");
			System.out.println("5 - Salir");
			System.out.println("Introduce una opción:");
			opcion = Integer.parseInt(sc.nextLine());
			switch(opcion) {
				case 1: {
					System.out.println("Introduce el nombre:");
					String nombre = sc.nextLine();
					System.out.println("Introduce el email:");
					String email = sc.nextLine();
					System.out.println("Introduce la edad:");
					int edad = Integer.parseInt(sc.nextLine());
					if(!gestionContactos.agregar(nombre, email, edad))
						System.out.println("Ya existe un contacto con el email: " + email);
					break;
				}
				case 2: {
					System.out.println("Introduce el email del contacto:");
					String email = sc.nextLine();
					Contacto contacto = gestionContactos.buscar(email);
					if(contacto == null)
						System.out.println("El contacto con email " + email + " no existe");
					else
						System.out.println("Nombre: " + contacto.getNombre() + ", email: " + contacto.getEmail() + ", edad: " + contacto.getEdad());
					break;
				}
				case 3: {
					System.out.println("Introduce el email del contacto a eliminar:");
					String email = sc.nextLine();
					if(!gestionContactos.eliminar(email))
						System.out.println("El contacto con email " + email + " no existe");
					else
						System.out.println("Contacto eliminado!.");
					break;
				}
				case 4:
					for(Contacto contacto: gestionContactos.obtenerContactos())
						System.out.println("Nombre: " + contacto.getNombre() + ", email: " + contacto.getEmail() + ", edad: " + contacto.getEdad());
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

}
