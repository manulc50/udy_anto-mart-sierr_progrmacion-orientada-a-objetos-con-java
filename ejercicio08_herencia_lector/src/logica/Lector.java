package logica;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;

public class Lector extends BufferedReader {
	
	// Establece el teclado como dispositivo de lectura 
	public Lector() {
		super(new InputStreamReader(System.in));
	}

	// Establece el dispositivo de lectura que se pase a este constructor
	public Lector(Reader in) {
		super(in);
	}
	
	public int readInt() throws IOException {
		return Integer.parseInt(readLine());
	}
	
	public double readDouble() throws IOException {
		return Double.parseDouble(readLine());
	}
}
