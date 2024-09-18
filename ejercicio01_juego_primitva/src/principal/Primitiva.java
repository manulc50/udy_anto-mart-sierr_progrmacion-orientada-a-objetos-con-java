package principal;

public class Primitiva {

	public static void main(String[] args) {
		int generados = 0;
		int[] nums = new int[6];
		do {
			// Genemramos un número aleatorio entre 1 y 49
			int num = (int)(Math.random() * 49 + 1);
			// Si no está repetido, lo guardamos en el array
			if(!esRepetido(num, nums, generados)) {
				nums[generados] = num;
				generados++;
			}
		}
		while(generados < nums.length);
		ordenar(nums);
		mostrar(nums);
	}
	
	private static boolean esRepetido(int num, int[] nums, int generados) {
		boolean resultado = false;
		for(int i = 0; i < generados; i++) {
			if(num == nums[i]) {
				resultado = true;
				break;
			}
		}
		return resultado;
	}
	
	// Algoritmo de la Burbuja
	private static void ordenar(int[] nums) {
		for(int i = 0; i < nums.length; i++) {
			for(int k = i + 1; k < nums.length; k++) {
				if(nums[k] < nums[i]) {
					int aux = nums[i];
					nums[i] = nums[k];
					nums[k] = aux;
				}
			}
		}
	}
	
	private static void mostrar(int[] nums) {
		for(int num: nums)
			System.out.print(num + ", ");
	}

}
