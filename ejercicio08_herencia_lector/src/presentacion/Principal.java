package presentacion;

import java.io.IOException;

import logica.Lector;

public class Principal {

	public static void main(String[] args) {
		// Lectura desde el teclado
		try(Lector lector = new Lector();) {
			System.out.print("Nombre: ");
			String nombre = lector.readLine();
			System.out.print("Edad: ");
			int edad = lector.readInt();
			System.out.println("Te llamas " + nombre + " y tienen " + edad + " años");
		}
		catch(IOException e) {
			e.printStackTrace();
		}
	}
}
