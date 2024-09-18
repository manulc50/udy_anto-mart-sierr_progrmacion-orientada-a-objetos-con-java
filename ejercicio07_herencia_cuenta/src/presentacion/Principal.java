package presentacion;

import logica.CuentaLimitada;

public class Principal {
	
	public static void main(String... args) {
		CuentaLimitada cl = new CuentaLimitada(100, 70);
		cl.extraer(90);
		System.out.println(cl.getSaldo());
	}
}
