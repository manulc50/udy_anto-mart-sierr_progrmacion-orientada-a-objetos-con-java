package logica;

import java.util.HashSet;
import java.util.Set;

import modelo.Movimiento;

public class CuentaMovimientos extends CuentaLimitada {
	private Set<Movimiento> movimientos;
	
	public CuentaMovimientos(double saldo, double limite) {
		super(saldo, limite);
		movimientos = new HashSet<>();
	}

	@Override
	public void extraer(double cantidad) {
		movimientos.add(new Movimiento(cantidad, "extracción"));
		super.extraer(cantidad);
	}

	@Override
	public void ingresar(double cantidad) {
		movimientos.add(new Movimiento(cantidad, "ingreso"));
		super.ingresar(cantidad);
	}
	
	public Set<Movimiento> getMovimientos() {
		return movimientos;
	}

}
