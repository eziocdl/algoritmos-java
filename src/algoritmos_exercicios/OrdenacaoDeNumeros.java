package algoritmos_exercicios;

import java.util.Arrays;
import java.util.Locale;
import java.util.Scanner;

/**
 * OrdenacaoDeNumeros: Ordena um array de números inteiros em ordem crescente
 * utilizando o algoritmo Merge Sort.
 */
public class OrdenacaoDeNumeros {

	/**
	 * Método principal que interage com o usuário, lê os números, ordena-os e
	 * imprime o resultado.
	 *
	 * @param args Os argumentos da linha de comando (não utilizados).
	 */
	public static void main(String[] args) {

		Locale.setDefault(Locale.US);

		try (Scanner sc = new Scanner(System.in)) {
			System.out.println("Insira a quantidade de números que deseja inserir: ");
			int quantidade = sc.nextInt();

			// Limpa o buffer do Scanner consumindo a quebra de linha deixada pelo nextInt()
			sc.nextLine();

			int[] numeros = new int[quantidade];

			System.out.println("Insira os números que deseja ordenar, separados por vírgula e espaço: ");

			String linha = sc.nextLine();

			// Separando os números por vírgula e espaço
			String[] numerosString = linha.split(", ");

			// Verifica se a quantidade de números está correta
			if (numerosString.length != quantidade) {
				throw new IllegalArgumentException(
						"Quantidade de números incorreta, favor digitar a quantidade que foi inserida: ");
			}

			// Converte as strings para inteiros
			for (int i = 0; i < quantidade; i++) {
				try {
					numeros[i] = Integer.parseInt(numerosString[i]);
	   } catch (NumberFormatException e) {
					throw new IllegalArgumentException(
							"Entrada inválida. Certifique-se de digitar apenas números inteiros.");
				}
			}

			// Imprimindo o Array Desordenado:
			System.out.println("Array desordenado: " + Arrays.toString(numeros));
            // chama a função mergeSort para ordenar os números
			mergeSort(numeros);

			// Imprimindo o Array Ordenado:
			System.out.println("Array ordenado: " + Arrays.toString(numeros));

			
			sc.close();
		}
	}

	/**
	 * Ordena um array de inteiros em ordem crescente utilizando o algoritmo Merge
	 * Sort.
	 *
	 * @param array O array de inteiros a ser ordenado.
	 */
	public static void mergeSort(int[] array) {

		// Se o array tem um tamanho 1 ou menor, já está ordenado
		if (array.length <= 1) {
			return;
		}

		// Dividindo o Array em duas metades
		int meio = array.length / 2;
		int[] esquerda = new int[meio];
		int[] direita = new int[array.length - meio];

		// Copiando os elementos para as sublistas
		System.arraycopy(array, 0, esquerda, 0, meio);
		System.arraycopy(array, meio, direita, 0, array.length - meio);

		// Chama recursivamente o mergeSort para as sublistas
		mergeSort(esquerda);
		mergeSort(direita);

		// Combina as sublistas ordenadas
		merge(array, esquerda, direita);

	}

	/**
	 * Função auxiliar que combina duas sublistas ordenadas em uma única lista
	 * ordenada.
	 *
	 * @param array    O array original que conterá a combinação das sublistas.
	 * @param esquerda A sublista esquerda ordenada.
	 * @param direita  A sublista direita ordenada.
	 */
	private static void merge(int[] array, int[] esquerda, int[] direita) {
		int i = 0, j = 0, k = 0;

		// Compara os elementos das sublistas e os coloca na lista principal
		while (i < esquerda.length && j < direita.length) {
			if (esquerda[i] <= direita[j]) {
				array[k] = esquerda[i];
				i++;
			} else {
				array[k] = direita[j];
				j++;
			}
			k++;
		}

		// Copia os elementos restantes da sublista esquerda, se houver
		while (i < esquerda.length) {
			array[k] = esquerda[i];
			i++;
			k++;
		}

		// Copia os elementos restantes da sublista direita, se houver
		while (j < direita.length) {
			array[k] = direita[j];
			j++;
			k++;
		}
	}

}