package logica;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.function.UnaryOperator;

public class GestionNumeros {

	public void procesar(List<Integer> numeros, Consumer<Integer> consumidor) {
		numeros.forEach(numero -> consumidor.accept(numero));
	}
	
	// Nota: UnaryOperator es una interfaz funcional que recibe dato de un tipo en concreto, realiza una función u operación con ese dato, y devuelve otro dato de ese mismo tipo(no distinto).
	public List<Integer> calcularFiltrados(List<Integer> numeros, Predicate<Integer> predicado, UnaryOperator<Integer> operacion) {
		List<Integer> numerosFiltrados = new ArrayList<>();
		numeros.forEach(numero -> {
			if(predicado.test(numero))
				numerosFiltrados.add(operacion.apply(numero));
		});
		return numerosFiltrados;
	}
}
