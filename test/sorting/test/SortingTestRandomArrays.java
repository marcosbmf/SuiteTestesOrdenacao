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
 * Sorting.
 * 
 * @author Marcos Barros
 */
@SuppressWarnings("unused")
public class SortingTestRandomArrays {

	private RandomArrayGenerator rd = new RandomArrayGenerator();
	private Integer[] array;

	public AbstractSorting<Integer> implementation;
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
		tamanhoMaximoArray = 20; // Escolha o tamanho máximo de cada array.
		valorMaximoElementos = 20; // Escolha o valor máximo dos elementos.
		this.implementation = null; // Classe que extende AbstractSorting<Integer>.
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
		this.array = rd.randomArrayComElementosNegativos(tamanhoMaximoArray, valorMaximoElementos);
	}

	// FIM DOS METODOS AUXILIARES

	// MÉTODOS DE TESTE

	public void genericTest(Integer[] array) {
		Integer[] copy1 = {};
		if (array.length > 0) {
			copy1 = Arrays.copyOf(array, array.length);
		}
		implementation.sort(array);
		try {
			Arrays.sort(copy1);
		} catch (Exception e) {}
		Assert.assertArrayEquals(copy1, array);
	}

	// TESTES

	@Test
	public void testSortVetoresTamPar() {
		int currentArray = 0;
		try {
			for (int i = 0; i < this.numRepeticoes; i++) {
				currentArray = i;
				populaVetorTamanhoPar();
				genericTest(array);
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
	public void testSortVetoresTamImpar() {
		int currentArray = 0;
		try {
			for (int i = 0; i < this.numRepeticoes; i++) {
				currentArray = i;
				populaVetorTamanhoImpar();
				genericTest(array);
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
	public void testSortVetoresValoresNegativoss() {
		int currentArray = 0;
		try {
			for (int i = 0; i < this.numRepeticoes; i++) {
				currentArray = i;
				populaVetorNegativo();
				genericTest(array);
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
		int currentArray = 0;
		try {
			for (int i = 0; i < this.numRepeticoes; i++) {
				currentArray = i;
				populaVetorRepetido();
				genericTest(array);
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
