package logica;

import java.io.IOException;
import java.nio.channels.FileChannel;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.List;
import java.util.stream.Stream;

import modelo.Contacto;

public class GestionContactos {
	private final static Path RUTA = Paths.get("contactos.txt");
	
	public GestionContactos() {
		if(!Files.exists(RUTA)) {
			try {
				Files.createFile(RUTA);
			}
			catch(IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	public boolean agregar(String nombre, String email, int edad) {
		boolean resultado = false;
		try {
			Files.write(RUTA, (nombre + "|" + edad + "|" + email + "\n").getBytes(), StandardOpenOption.APPEND);
			resultado = true;
		}
		catch(IOException e) {
			e.printStackTrace();
		}
		return resultado;
	}
	
	public Contacto buscar(String email) {
		Contacto contacto = null;
		try(Stream<String> lineas = Files.lines(RUTA)) {
			contacto = lineas.map(linea -> linea.split("\\|"))
					.filter(datos -> datos[2].equals(email))
					.findFirst()
					.map(datos -> new Contacto(datos[0], datos[2], Integer.parseInt(datos[1])))
					.orElse(null);
		}
		catch(IOException e) {
			e.printStackTrace();
		}
		return contacto;
	}
	
	public boolean eliminar(String email) {
		boolean resultado = false;
		try {
			List<String> lineas = Files.readAllLines(RUTA);
			// Una vez leído todo el archivo, lo truncamos para añadir el nuevo contenido a continuación
			FileChannel.open(RUTA, StandardOpenOption.WRITE).truncate(0).close();
			for(String linea: lineas) {
				if(linea.contains(email))
					resultado = true;
				else
					Files.write(RUTA, (linea + "\n").getBytes(), StandardOpenOption.APPEND);
			}
		}
		catch(IOException e) {
			e.printStackTrace();
		}
		return resultado;
			
	}
	
	public Contacto[] obtenerContactos() {
		Contacto[] contactos = null;
		try(Stream<String> lineas = Files.lines(RUTA)) {
			contactos = lineas
					.map(linea -> {
						String[] datos = linea.split("\\|");
						return new Contacto(datos[0], datos[2], Integer.parseInt(datos[1]));
					})
					.toArray(tam -> new Contacto[tam]);
		}
		catch(IOException e) {
			e.printStackTrace();
		}
		return contactos;
	}
}
