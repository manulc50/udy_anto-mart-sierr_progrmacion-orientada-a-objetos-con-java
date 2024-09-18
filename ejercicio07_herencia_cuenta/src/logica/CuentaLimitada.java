package logica;

public class CuentaLimitada extends Cuenta {
	private double limite;
	
	public CuentaLimitada(double saldo, double limite) {
		super(saldo);
		this.limite = limite;
	}
	
	public void fijarLimite() {
		limite = getSaldo() / 2;
	}
}
