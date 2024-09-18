package presentacion;

import java.util.Arrays;
import java.util.List;

import logica.GestionNumeros;

public class Principal {

	public static void main(String[] args) {
		List<Integer> numeros = Arrays.asList(4, 11, 23, 15, 16, 33);
		GestionNumeros gestorNumeros = new GestionNumeros();
		System.out.println("Imprimir números:");
		gestorNumeros.procesar(numeros, numero -> System.out.println(numero));
		System.out.println("Cuadrados de pares:");
		for(Integer numero: gestorNumeros.calcularFiltrados(numeros, numero -> numero % 2 == 0, numero -> numero * numero))
			System.out.println(numero);
	}
}
