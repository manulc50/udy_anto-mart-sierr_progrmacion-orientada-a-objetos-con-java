package logica;

import java.util.ArrayList;
import java.util.List;

public class GestionNotas {
	private List<Double> notas;
	
	public GestionNotas() {
		notas = new ArrayList<>();
	}
	
	public void guardarNota(double nota) {
		notas.add(nota);
	}
	
	public double calcularMedia() {
		double suma = 0;
		for(double nota: notas)
			suma += nota;
		return suma / notas.size();
	}
	
	public int obtenerAprobados() {
		int aprobados = 0;
		for(double nota: notas) {
			if(nota > 5)
				aprobados++;
		}
		return aprobados;
	}
	
	public Double[] obtenerNotasOrdenadas() {
		// Este método "sort" recibe una implementación de la interfaz Comparator que es una interfaz funcional.
		// Por lo tanto, podemos implementar dicha interfaz con una función lambda.
		notas.sort((nota1, nota2) -> (int)(nota1 - nota2));
		return notas.toArray(new Double[0]);
	}
	
	public void eliminarSuspensos() {
		// Este método "removeIf" recibe una implementación de la interfaz Predicate que es una interfaz funcional.
		// Por lo tanot, puede ser implementada por una función lambda.
		notas.removeIf(nota -> nota < 5);
	}
}
