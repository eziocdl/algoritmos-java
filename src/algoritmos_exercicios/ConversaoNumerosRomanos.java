package algoritmos_exercicios;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Scanner;

public class ConversaoNumerosRomanos {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);

		Scanner sc = new Scanner(System.in);
		String letrasString;

		while (true) {

			// looping infinito para o usuário digitar um valor válido

			System.out.println("Insira o número em romanos que irá ser convertido para inteiro: ");
			letrasString = sc.nextLine();
			letrasString = letrasString.toUpperCase();

			if (letrasString.matches("^[IVXLCDM]+$")) {
				// Sai do loop se a entrada do usuário for válida

				break;
			} else {

				System.out.println("Digite apenas letras do algarismo romano (I, V, X, L, C, D, M)");
			}

		}

		// chamar o método para criar o mapa de romanos

		Map<Character, Integer> romanos = CriarMapaRomanos();

		int resultado = 0;
		int valorAnterior = 0;

		for (int i = letrasString.length() - 1; i >= 0; i--) {
			char letra = letrasString.charAt(i);
			int valorAtual = romanos.get(letra);

			if (valorAtual < valorAnterior) {
				resultado -= valorAtual;
			} else {

				resultado += valorAtual;
			}

			valorAnterior = valorAtual;

		}

		System.out.println("O número romano " + letrasString + " corresponde a  " + resultado);

		sc.close();
	}

	// método map para associar as letras com os resultados inteiros

	private static Map<Character, Integer> CriarMapaRomanos() {
		Map<Character, Integer> romanos = new HashMap<>();

		romanos.put('I', 1);
		romanos.put('V', 5);
		romanos.put('X', 10);
		romanos.put('L', 50);
		romanos.put('C', 100);
		romanos.put('D', 500);
		romanos.put('L', 100);

		return romanos;

	};

}
