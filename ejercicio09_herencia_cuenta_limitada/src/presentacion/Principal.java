package presentacion;

import logica.CuentaLimitada;
import logica.CuentaMovimientos;
import modelo.Movimiento;

public class Principal {
	
	public static void main(String... args) {
		CuentaLimitada cl = new CuentaLimitada(100, 70);
		cl.extraer(90);
		System.out.println("Saldo de la cuenta limitada: " + cl.getSaldo());
		
		CuentaMovimientos cm = new CuentaMovimientos(200, 100);
		cm.ingresar(50);
		cm.extraer(70);
		System.out.println("Saldo de la cuenta con movimientos: " + cm.getSaldo());
		System.out.println("Movimientos:");
		for(Movimiento movimiento: cm.getMovimientos())
			System.out.println("Cantidad: " + movimiento.getCantidad() + ", Tipo: " + movimiento.getTipo());
	}
}
