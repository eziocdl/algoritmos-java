package algoritmos_exercicios;

import java.util.Locale;
import java.util.Scanner;

public class Palindromo {

	/**
	 * Detecção de Palíndromo Crie um algoritmo que receba uma string e determine se
	 * ela é um palíndromo (desconsiderando espaços e diferenças entre maiúsculas e
	 * minúsculas)
	 **/

	public static void main(String[] args) {

		Locale.setDefault(Locale.US);

		// definindo a entrada e tratando um possível erro

		Scanner sc = new Scanner(System.in);

		System.out.println("Insira a palavra desejada para indentificar se é palíndromo: ");
		String palavra = sc.nextLine();

		// tratamento de erros antes chamar os método.

		if (ehUmaEntradaValida(palavra)) {
			String palavraLimpa = limparString(palavra);

			if (ehPalindromo(palavraLimpa)) {

				System.out.println(" A palavra " + palavraLimpa + " É um palíndromo.");

			} else {

				System.out.println(" A palavra " + palavraLimpa + " não é um palíndromo.");

			}
		} else {

			System.out.println("Erro, a entrada não pode ser vazia.");

		}

	
		sc.close();
	}
	
	
	

	// métodos

	// tratamento de erro verificando se é uma entrada válida

	private static boolean ehUmaEntradaValida(String input) {

		return input != null && !input.trim().isEmpty();
	}

	// limpando a String e convertendo todas as letras para minúscula

	private static String limparString(String input) {
		return input.replaceAll(" ", "").toLowerCase();
	}

	// condicao

	// primeiro ela inverte a palavra e verifica se o verso e o inverso é igual e
	// converte para string

	private static boolean ehPalindromo(String string) {
		String inverse = new StringBuilder(string).reverse().toString();
		return string.equals(inverse);
	}

}
