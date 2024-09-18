package presentacion;

import java.util.List;
import java.util.Scanner;

import logica.GestionEmpleados;
import modelo.Empleado;

public class Principal {
	
	public static void main(String... args) {
		GestionEmpleados gestionEmpleados = new GestionEmpleados();
		Scanner sc = new Scanner(System.in);
		int opcion = 0;
		while(opcion != 7) {
			System.out.println("1 - Añadir empleado");
			System.out.println("2 - Buscar empleado por email");
			System.out.println("3 - Mostrar empleados ordenados por edad");
			System.out.println("4 - Mostrar empleados de un departamento");
			System.out.println("5 - Obtener la media del salario de un departamento");
			System.out.println("6 - Obtener el nombre del empleado con mayor sueldo");
			System.out.println("7 - Salir");
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
					System.out.println("Introduce el departamento:");
					String departamento = sc.nextLine();
					System.out.println("Introduce el salario:");
					double salario = Double.parseDouble(sc.nextLine());
					if(!gestionEmpleados.agregar(nombre, email, edad, departamento, salario))
						System.out.println("Ya existe un empleado con el email: " + email);
					break;
				}
				case 2: {
					System.out.println("Introduce el email del empleado:");
					String email = sc.nextLine();
					Empleado empleado = gestionEmpleados.buscarPorEmail(email);
					if(empleado == null)
						System.out.println("El empleado con email " + email + " no existe");
					else
						System.out.println("Nombre: " + empleado.getNombre() + ", email: " + empleado.getEmail() + ", edad: " + empleado.getEdad() +
								", departamento: " + empleado.getDepartamento() + ", salario: " + empleado.getSalario());
					break;
				}
				case 3:
					mostrarEmpleados(gestionEmpleados.obtenerEmpleadosOrdernadosPorEdad());
					break;
				case 4: {
					System.out.println("Introduce el departamento:");
					String departamento = sc.nextLine();
					mostrarEmpleados(gestionEmpleados.buscarPorDepartamento(departamento));
					break;
				}
				case 5: {
					System.out.println("Introduce el departamento:");
					String departamento = sc.nextLine();
					System.out.println("La media de los salarios del departamento " + departamento +
							" es " + gestionEmpleados.calcularMediaSalarioPorDepartamento(departamento));
					break;
				}
				case 6:
					String nombreEmpleado = gestionEmpleados.obtenerNombreEmpleadoMayorSalario();
					if(nombreEmpleado == null)
						System.out.println("No hay empleados");
					else
						System.out.println("El nombre del empleado con mayor sueldo es " + nombreEmpleado);
					break;
				case 7:
					sc.close();
					break;
				default:
					System.out.println("Opción inválida");
					break;
			}
		}
	}
	
	private static void mostrarEmpleados(List<Empleado> empleados) {
		if(empleados == null || empleados.size() == 0)
			System.out.println("No hay empleados");
		else {
			for(Empleado empleado: empleados)
				System.out.println("Nombre: " + empleado.getNombre() + ", email: " + empleado.getEmail() + ", edad: " + empleado.getEdad() +
						", departamento: " + empleado.getDepartamento() + ", salario: " + empleado.getSalario());
		}
	}

}
