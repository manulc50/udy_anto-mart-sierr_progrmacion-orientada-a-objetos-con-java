package principal;

import java.util.Scanner;

/*
  Nota: Es recomendable y debe usarse StringBuilder cuando queremor realizar una gran cantidad de operaciones
  sobre una cadena de texto(Por ejemplo, concatenaciones dentro de un bucle) y así evitar la creación de múltiples
  objetos de tipo String cuando realizamos las operaciones directamente sobre los Strings. Ésto es debido a que un
  StringBuilder es mutable(Por lo tanto, no se crean nuevos objetos por cada modificación) y un String es inmutable
  (Por lo tanto, se crea un nuevo objeto por cada modificación).  
*/

public class Invertir {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in); 
		System.out.println("Introduce una cadena de texto:");
		String cadena = sc.nextLine();
		sc.close();
		StringBuilder sb = new StringBuilder(cadena.length());
		for(int i = cadena.length() - 1; i >= 0; i--)
			sb.append(cadena.charAt(i));
		System.out.println(sb.toString());
	}

}
