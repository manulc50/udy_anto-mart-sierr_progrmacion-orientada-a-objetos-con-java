package logica;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import modelo.Alumno;

public class GestionAlumnos {
	private final static Path RUTA = Paths.get("alumnos.csv");
	
	public double calcularNotaMediaPorCurso(String curso) {
		return obtenerStreamAlumnos()
				.filter(alumno -> alumno.getCurso().equals(curso))
				.mapToDouble(alumno -> alumno.getNota())
				.average().orElse(0.);
	}
	
	public List<Alumno> obtenerAlumnosPorCurso(String curso) {
		return obtenerStreamAlumnos()
				.filter(alumno -> alumno.getCurso().equals(curso))
				.collect(Collectors.toList());
	}
	
	public Alumno obtenerAlumnoConNotaMasAlta() {
		return obtenerStreamAlumnos()
				.max((a1, a2) -> Float.compare(a1.getNota(), a2.getNota()))
				.orElse(null);
	}
	
	public List<String> obtenerNombreCursos() {
		return obtenerStreamAlumnos()
				.map(alumno -> alumno.getCurso())
				.distinct()
				.collect(Collectors.toList());
	}
	
	private Stream<Alumno> obtenerStreamAlumnos() {
		try(Stream<String> lineas = Files.lines(RUTA)) {
			return lineas.map(linea -> linea.split(","))
					.map(datos -> new Alumno(datos[0], datos[1], Float.parseFloat(datos[2])));
		}
		catch(IOException e) {
			e.printStackTrace();
			return Stream.empty();
		}
	}
}
