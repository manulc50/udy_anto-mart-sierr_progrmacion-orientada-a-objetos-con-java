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
				aprobados ++;
		}
		return aprobados;	
	}
}
