package logica;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import modelo.Empleado;

public class GestionEmpleados {
	private final static Path RUTA = Paths.get("empleados.txt");
	
	public GestionEmpleados() {
		if(!Files.exists(RUTA)) {
			try {
				Files.createFile(RUTA);
			}
			catch(IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	public boolean agregar(String nombre, String email, int edad, String departamento, double salario) {
		boolean resultado = false;
		if(buscarPorEmail(email) == null) {
			try {
				Files.write(RUTA, (nombre + "|" + email + "|" + salario + "|" + edad + "|" + departamento + "\n").getBytes(),
						StandardOpenOption.APPEND);
				resultado = true;
			}
			catch(IOException e) {
				e.printStackTrace();
			}
		}
		return resultado;
	}
	
	public Empleado buscarPorEmail(String email) {
		Empleado contacto = null;
		try(Stream<String> lineas = Files.lines(RUTA)) {
			contacto = lineas.map(linea -> linea.split("[|]"))
					.filter(datos -> datos[1].equals(email))
					.findFirst()
					.map(datos -> new Empleado(datos[0], datos[1], Integer.parseInt(datos[3]), datos[4], Double.parseDouble(datos[2])))
					.orElse(null);
		}
		catch(IOException e) {
			e.printStackTrace();
		}
		return contacto;
	}
	
	public List<Empleado> obtenerEmpleadosOrdernadosPorEdad() {
		try(Stream<String> lineas = Files.lines(RUTA)) {
			return lineas.map(linea -> linea.split("[|]"))
					.map(datos -> new Empleado(datos[0], datos[1], Integer.parseInt(datos[3]), datos[4], Double.parseDouble(datos[2])))
					.sorted((emp1, emp2) -> emp1.getEdad() - emp2.getEdad())
					.collect(Collectors.toList());
		}
		catch(IOException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public List<Empleado> buscarPorDepartamento(String departamento) {
		try(Stream<String> lineas = Files.lines(RUTA)) {
			return lineas.map(linea -> linea.split("[|]"))
					.filter(datos -> datos[4].equals(departamento))
					.map(datos -> new Empleado(datos[0], datos[1], Integer.parseInt(datos[3]), datos[4], Double.parseDouble(datos[2])))
					.collect(Collectors.toList());
		}
		catch(IOException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public double calcularMediaSalarioPorDepartamento(String departamento) {
		return buscarPorDepartamento(departamento).stream()
				.mapToDouble(empleado -> empleado.getSalario())
				.average().orElse(0.0);
				
	}
	
	public String obtenerNombreEmpleadoMayorSalario() {
		try(Stream<String> lineas = Files.lines(RUTA)) {
			return lineas.map(linea -> linea.split("[|]"))
					.max((datos1, datos2) -> Double.compare(Double.parseDouble(datos1[2]), Double.parseDouble(datos2[2])))
					.map(datos -> datos[0]).orElse(null);
		}
		catch(IOException e) {
			e.printStackTrace();
			return null;
		}
	}
	
}
