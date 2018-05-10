package util;

import java.util.Random;

/**
 * Gera arrays de Inteiros Aleatórios a partir de parametros utilizando o pacote Random.
 * @author Marcos Barros
 *
 */
public class RandomArrayGenerator {

	Random rd = new Random();
	
	/**
	 * Construtor de array aleatório.
	 * @param tamanho Tamanho do array.
	 * @param valorInteiroMaximo Valor máximo para os inteiros que populam o array.
	 * @param negativo Boolean que assegura se o array deve ter valores negativos.
	 * @param negativoCompleto Boolean que assegura se todos os valores do array devem ser negativos.
	 * @return Array randomizado de acordo com as características passadas.
	 */
	public Integer[] randomArray(int tamanho, int valorInteiroMaximo, boolean negativo, boolean negativoCompleto) {
		Integer[] temp = new Integer[tamanho];
		for (int i = 0; i < tamanho; i++) {
			temp[i] = rd.nextInt(valorInteiroMaximo + 1);
		}
		if (negativo) {
			this.negativeArray(temp, negativoCompleto);
		}
		return temp;
	}
	
	/**
	 * Gera array de tamanho randomizado e par, populado por elementos randomizados dentro do intervalo escolhido.
	 * Intervalo dos valores: [0, valorInteiroMaximo]
	 * @param tamanhoMaximo tamanho máximo do array.
	 * @param valorInteiroMaximo valor máximo assumido pelos inteiros dentro do array.
	 * @return Um array randomizado de acordo com as caractéristicas passadas.
	 */
	public Integer[] randomArrayPar(int tamanhoMaximo, int valorInteiroMaximo) {
		return this.randomArray(this.tamanhoPar(tamanhoMaximo), valorInteiroMaximo, false, false);
	}
	
	/**
	 * Gera array de tamanho randomizado e impar, populado por elementos randomizados dentro do intervalo escolhido.
	 * Intervalo dos valores: [0, valorInteiroMaximo]
	 * @param tamanhoMaximo tamanho máximo do array.
	 * @param valorInteiroMaximo valor máximo assumido pelos inteiros dentro do array.
	 * @return Um array randomizado de acordo com as caractéristicas passadas.
	 */
	public Integer[] randomArrayImpar(int tamanhoMaximo, int valorInteiroMaximo) {
		return this.randomArray(this.tamanhoImpar(tamanhoMaximo), valorInteiroMaximo, false, false);
	}
	
	/**
	 * Gera array de tamanho randomizado que possui elementos repetidos(100%).
	 * Intervalo dos valores: [0, tamanhoRandomizado - 1]
	 * @param tamanhoMaximo tamanho máximo do array.
	 * @return Um array randomizado de acordo com as caractéristicas passadas.
	 */
	public Integer[] randomArrayRepetidos(int tamanhoMaximo) {
		int tamanhoRandom = this.tamanhoRandom(tamanhoMaximo);
		return this.randomArray(tamanhoRandom, tamanhoRandom-1, false, false);
	}
	
	/**
	 * Gerador de array mais completo, tamanho randomizado com valores positivos e negativos.
	 * Intervalo dos valores: [-valorInteiroMaximo, valorInteiroMaximo]
	 * @param tamanhoMaximo tamanho máximo do array.
	 * @param valorInteiroMaximo valor máximo assumido pelos inteiros dentro do array.
	 * @return Um array randomizado de acordo com as caractéristicas passadas.
	 */
	public Integer[] randomArrayComElementosNegativos(int tamanhoMaximo, int valorInteiroMaximo) {
		return this.randomArray(this.tamanhoRandom(tamanhoMaximo), valorInteiroMaximo, true, false);
	}
	
	/**
	 * Gera array de tamanho randomizado com valores apenas negativos.
	 * Intervalo dos valores: [-valorInteiroMaximo, 0]
	 * @param tamanhoMaximo tamanho máximo do array.
	 * @param valorInteiroMaximo valor máximo assumido pelos inteiros dentro do array.
	 * @return Um array randomizado de acordo com as caractéristicas passadas.
	 */
	public Integer[] randomArrayCompletoNegativo(int tamanhoMaximo, int valorInteiroMaximo) {
		return this.randomArray(this.tamanhoRandom(tamanhoMaximo), valorInteiroMaximo, true, true);
	}
	
	
	/**
	 * Função que torna os elementos do array negativos. Número de elementos randomizado ou total.
	 * @param array Array a ser alterado.
	 * @param negativoCompleto Caso true, todos os elementos se tornam negativos. Caso false, um número randomizado de elementos se torna negativo.
	 */
	private void negativeArray(Integer[] array, boolean negativoCompleto) {
		if (negativoCompleto) {
			for (int i = 0; i < array.length; i++) {
			array[i] *= -1;
			}
		} else {
			for (int i = 0; i < array.length; i++) {
				if(rd.nextBoolean()) {
				array[i] *= -1;
				}
			}
		}
	}

	/**
	 * Escolhe um tamanho par entre o tamanho máximo.
	 * @param tamanhoMaximo Tamanho máximo do array.
	 * @return inteiro representando o tamanho do array.
	 */
	private int tamanhoPar(int tamanhoMaximo) {
		if (tamanhoMaximo < 2) {
			throw new IllegalArgumentException();
		}
		int num;
		do {
			num = rd.nextInt(tamanhoMaximo + 1);
		} while (num % 2 == 1 || num == 0);
		return num;
	}

	/**
	 * Escolhe um tamanho impar entre o tamanho máximo.
	 * @param tamanhoMaximo Tamanho máximo do array.
	 * @return inteiro representando o tamanho do array.
	 */
	private int tamanhoImpar(int tamanhoMaximo) {
		if (tamanhoMaximo < 2) {
			throw new IllegalArgumentException();
		}
		int num;
		do {
			num = rd.nextInt(tamanhoMaximo + 1);
		} while (num % 2 == 0 || num == 0);
		return num;
	}

	/**
	 * Escolhe um tamanho aleatório entre o tamanho máximo.
	 * @param tamanhoMaximo Tamanho máximo do array.
	 * @return inteiro representando o tamanho do array.
	 */
	private int tamanhoRandom(int tamanhoMaximo) {
		int num;
		do {
			num = rd.nextInt(tamanhoMaximo + 1);
		} while (num == 0);
		return num;
	}

	/**
	 * Escolhe randomicamente um dos índices do array para ser o leftIndex na ordenação parcial. 
	 * @param array Array a ser ordenado.
	 * @return Inteiro nos limites do tamanho do array.
	 */
	public int getLeft(Integer[] array) {
		return rd.nextInt(array.length);
	}

	/**
	 * Escolhe randomicamente um dos índices do array para ser o rightIndex na ordenação parcial, baseado no leftIndex escolhido anteriormente.
	 * @param array Array a ser ordenado.
	 * @return Inteiro nos limites do tamanho do array e maior que o leftIndex.
	 */
	public int getRight(Integer[] array, int leftIndex) {
		return leftIndex + rd.nextInt(array.length - leftIndex);
	}

}
