package auxiliar;

public interface Proceso {
	void imprimir();
	void aumentar(float cantidad);
	default void firmar() {
		System.out.println(this.toString());
	}
}
