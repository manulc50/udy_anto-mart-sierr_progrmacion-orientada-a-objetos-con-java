package logica;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import modelo.Contacto;

public class GestionContactos {
	private final static String RUTA = "contactos.txt";
	
	public GestionContactos() {
		File archivo = new File(RUTA);
		if(!archivo.exists()) {
			try {
				archivo.createNewFile();
			}
			catch(IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	public boolean agregar(String nombre, String email, int edad) {
		boolean resultado = false;
		if(buscar(email) == null) {
			try(FileOutputStream fos = new FileOutputStream(RUTA, true);
					PrintStream salida = new PrintStream(fos)) {
				salida.println(nombre + "|" + edad + "|" + email);
				resultado = true;
			}
			catch(IOException e) {
				e.printStackTrace();
			}
		}
		return resultado;
	}
	
	public Contacto buscar(String email) {
		Contacto contacto = null;
		try(BufferedReader br = new BufferedReader(new FileReader(RUTA))) {
			String linea;
			while((linea = br.readLine()) != null) {
				String[] datos = linea.split("\\|");
				if(datos[2].equals(email)) {
					contacto = new Contacto(datos[0], datos[2], Integer.parseInt(datos[1]));
					break;
				}
			}
		}
		catch(IOException e) {
			e.printStackTrace();
		}
		return contacto;
	}
	
	public boolean eliminar(String email) {
		Contacto[] contactos = obtenerContactos();
		boolean resultado = false;
		try(PrintStream salida = new PrintStream(RUTA)) {
			for(Contacto contacto: contactos) {
				if(contacto.getEmail().equals(email)) {
					resultado = true;
					continue;
				}
				salida.println(contacto.getNombre() + "|" + contacto.getEdad() + "|" + contacto.getEmail());
			}
		}
		catch(IOException e) {
			e.printStackTrace();
		}
		return resultado;
	}
	
	public Contacto[] obtenerContactos() {
		List<Contacto> contactos = new ArrayList<>();
		try(BufferedReader br = new BufferedReader(new FileReader(RUTA))) {
			String linea;
			while((linea = br.readLine()) != null) {
				String[] datos = linea.split("\\|");
				contactos.add(new Contacto(datos[0], datos[2], Integer.parseInt(datos[1])));
			}
		}
		catch(IOException e) {
			e.printStackTrace();
		}
		return contactos.toArray(new Contacto[0]);
	}
}
