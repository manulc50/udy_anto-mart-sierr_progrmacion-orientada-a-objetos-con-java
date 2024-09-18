package presentacion;

import java.util.Scanner;

import logica.GestionNotas;

public class Principal {

	public static void main(String[] args) {
		GestionNotas gestionNotas = new GestionNotas();
		Scanner sc = new Scanner(System.in);
		int operacion;
		do {
			System.out.println("1 - Añadir nota");
			System.out.println("2 - Ver media");
			System.out.println("3 - Ver número de aprobados");
			System.out.println("4 - Ver notas ordenadas");
			System.out.println("5 - Salir");
			System.out.println("Introduce una opción:");
			operacion = Integer.parseInt(sc.nextLine());
			switch(operacion) {
				case 1: {
					System.out.println("Introduce la nota:");
					double nota = Double.parseDouble(sc.nextLine());
					gestionNotas.guardarNota(nota);
					break;
				}
				case 2:
					System.out.println("Media actual: " + gestionNotas.calcularMedia());
					break;
				case 3:
					System.out.println("Número de aprobados: " + gestionNotas.obtenerAprobados());
					break;
				case 4:
					for(Double nota: gestionNotas.obtenerNotasOrdenadas())
						System.out.print(nota + ",");
					System.out.println();
					break;
				case 5:
					sc.close();
					break;
				default:
					System.out.println("Opción inválida");
					break;
			}
		}
		while(operacion != 5);

	}

}
