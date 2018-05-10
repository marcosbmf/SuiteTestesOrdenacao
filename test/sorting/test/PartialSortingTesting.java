package sorting.test;

import java.util.Arrays;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import sorting.AbstractSorting;
import util.RandomArrayGenerator;

/**
 * Classe que realiza testes usando arrays criados aleatóriamente, com tamanhos
 * aleatórios, em algoritmos de ordenação que extendem a classe Abstract
 * Sorting, usando ordenação parcial de arrays. Os arrays são aleatórios de
 * acordo com as configurações do usuário e trabalha apenas com números
 * inteiros.
 * 
 * @author Marcos Barros
 */
@SuppressWarnings("unused")
public class PartialSortingTesting {

	private RandomArrayGenerator rd = new RandomArrayGenerator();
	private Integer[] array;
	private AbstractSorting<Integer> implementation;

	// Variáveis de configuração.
	private int numRepeticoes;
	private int tamanhoMaximoArray;
	private int valorMaximoElementos;

	/**
	 * Configurações do usuário. Cada teste é repetido "numRepeticoes" vezes, sempre
	 * com arrays aleatórios diferentes que possuem um tamanho máximo
	 * "tamanhoMaximoArray" e seus elementos variam entre 0 e
	 * "valorMaximoElementos".
	 */
	@Before
	public void configuracoes() {
		numRepeticoes = 1000; // Escolha o número de repetições.
		tamanhoMaximoArray = 200; // Escolha o tamanho máximo de cada array.
		valorMaximoElementos = 200; // Escolha o valor máximo dos elementos.
		this.implementation = null; // Classe que extende AbstractSorting, parametrizada para <Integer> se necessário.
	}

	// // MÉTODOS AUXILIARES

	private void populaVetorTamanhoPar() {
		this.array = rd.randomArrayPar(this.tamanhoMaximoArray, this.valorMaximoElementos);
	}

	private void populaVetorTamanhoImpar() {
		this.array = rd.randomArrayImpar(this.tamanhoMaximoArray, this.valorMaximoElementos);
	}

	private void populaVetorRepetido() {
		this.array = rd.randomArrayRepetidos(this.tamanhoMaximoArray);
	}

	private void populaVetorNegativo() {
		this.array = rd.randomArrayComElementosNegativos(this.tamanhoMaximoArray, this.valorMaximoElementos);
	}

	// // FIM DOS METODOS AUXILIARES

	// // MÉTODOS DE TESTE PARA ORDENAÇÕES PARCIAIS.

	public void genericTest(Integer[] array, int leftIndex, int rightIndex) {
		Integer[] copy1 = {};
		if (array.length > 0) {
			copy1 = Arrays.copyOf(array, array.length);
		}
		implementation.sort(array, leftIndex, rightIndex);

		try {
			Arrays.sort(copy1, leftIndex, rightIndex + 1);
		} catch (Exception e) {

		}
		Assert.assertArrayEquals(copy1, array);
	}

	// // TESTES

	@Test
	public void testSortParcialVetoresTamPar() {
		int left;
		int right;
		int currentArray = 0;
		try {
			for (int i = 0; i < this.numRepeticoes; i++) {
				currentArray = i;
				populaVetorTamanhoPar();
				left = rd.getLeft(array);
				right = rd.getRight(array, left);
				genericTest(array, left, right);
			}
		} catch (AssertionError e) {
			System.out.println(e.getClass().getSimpleName() + " no array número: " + currentArray);
			System.out.println(Arrays.toString(array));
			e.printStackTrace();
			throw new AssertionError();
		} catch(Exception e) {
			System.out.println(e.getClass().getSimpleName() + " no array número: " + currentArray);
			System.out.println(Arrays.toString(array));
			e.printStackTrace();
			throw new AssertionError();
		}
	}

	@Test
	public void testSortParcialVetoresTamImpar() {
		int left;
		int right;
		int currentArray = 0;
		try {
			for (int i = 0; i < this.numRepeticoes; i++) {
				currentArray = i;
				populaVetorTamanhoImpar();
				left = rd.getLeft(array);
				right = rd.getRight(array, left);
				genericTest(array, left, right);
			}
		} catch (AssertionError e) {
			System.out.println(e.getClass().getSimpleName() + " no array número: " + currentArray);
			System.out.println(Arrays.toString(array));
			e.printStackTrace();
			throw new AssertionError();
		} catch(Exception e) {
			System.out.println(e.getClass().getSimpleName() + " no array número: " + currentArray);
			System.out.println(Arrays.toString(array));
			e.printStackTrace();
			throw new AssertionError();
		}
	}

	@Test
	public void testSortParcialVetoresNegativos() {
		int left;
		int right;
		int currentArray = 0;
		try {
			for (int i = 0; i < this.numRepeticoes; i++) {
				currentArray = i;
				populaVetorNegativo();
				left = rd.getLeft(array);
				right = rd.getRight(array, left);
				genericTest(array, left, right);
			}
		} catch (AssertionError e) {
			System.out.println(e.getClass().getSimpleName() + " no array número: " + currentArray);
			System.out.println(Arrays.toString(array));
			e.printStackTrace();
			throw new AssertionError();
		} catch(Exception e) {
			System.out.println(e.getClass().getSimpleName() + " no array número: " + currentArray);
			System.out.println(Arrays.toString(array));
			e.printStackTrace();
			throw new AssertionError();
		}
	}

	@Test
	public void testSortVetoresValoresRepetidos() {
		int left;
		int right;
		int currentArray = 0;
		try {
			for (int i = 0; i < this.numRepeticoes; i++) {
				currentArray = i;
				populaVetorRepetido();
				left = rd.getLeft(array);
				right = rd.getRight(array, left);
				genericTest(array, left, right);
			}
		} catch (AssertionError e) {
			System.out.println(e.getClass().getSimpleName() + " no array número: " + currentArray);
			System.out.println(Arrays.toString(array));
			e.printStackTrace();
			throw new AssertionError();
		} catch(Exception e) {
			System.out.println(e.getClass().getSimpleName() + " no array número: " + currentArray);
			System.out.println(Arrays.toString(array));
			e.printStackTrace();
			throw new AssertionError();
		}
	}
}
