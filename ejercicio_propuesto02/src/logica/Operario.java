package logica;

import java.time.LocalDate;
import java.time.Period;

public class Operario extends Empleado {
	private int nivel;

	public Operario(String nombre, int edad, LocalDate fechaIngreso, double salario, int nivel) {
		super(nombre, edad, fechaIngreso, salario);
		this.nivel = nivel;
	}
	
	@Override
	public void incentivar() {
		if(getEdad() > 30 && nivel > 2)
			setSalario(getSalario() + BONO *2);
		else if(getEdad() > 30 || nivel > 2)
			setSalario(getSalario() + BONO);
	}
	
	public void actualizarNivel() {
		final long meses = Period.between(getFechaIngreso(), LocalDate.now()).toTotalMonths();
		if(meses > 24 && nivel < 5)
			nivel++;	
	}

	public int getNivel() {
		return nivel;
	}

	public void setNivel(int nivel) {
		this.nivel = nivel;
	}

}
