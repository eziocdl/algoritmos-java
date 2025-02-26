package algoritmos_refatorados;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class AutoCompletarRefact {

	// refatorando usando programação orientada a testes

	public static void main(String[] args) throws IOException, URISyntaxException {
		// ajustando o arquivo para que seja lido as palavras ordenando-as como uma
		// liste
		List<String> palavras = lerArquivo("palavras.txt");

		// Interação com o usuário para que ele digite a letra

		// tratando excecoes desde o começo

		Scanner sc = new Scanner(System.in);

		while (true) {
			System.out.println("Digite o prefixo (ou sair para encerrar: ");
			String prefixo = sc.nextLine();

			if (prefixo.equalsIgnoreCase("sair")) {
				break;
			}

			// Caso não digite sair, abaixo vai acessar a lista de sugestões de acordo com o
			// prefixo que foi digitado.

			List<String> sugestoes = buscarSugestoes(prefixo, palavras);

			if (sugestoes.isEmpty()) {

				System.out.println("Nenhuma palavra encontrada.");
			} else {

				// caso tenha sugestão de acordo com o prefixo, elas serão impressas.
				System.out.println("sugestões: " + sugestoes);
			}
		}
		sc.close();

	}

	// método ler arquivo.

	private static List<String> lerArquivo(String nomeArquivo) throws IOException, URISyntaxException {
		List<String> palavras = new ArrayList<>();
		try (InputStream inputStream = AutoCompletarRefact.class.getClassLoader().getResourceAsStream(nomeArquivo);
				BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream))) {

			if (inputStream == null) {
				throw new IOException("Arquivo  não encontrado: " + nomeArquivo);

			}

			String linha;

			while ((linha = reader.readLine()) != null) {
				palavras.add(linha);
			}

			if (palavras.isEmpty()) {
				throw new IOException("Arquivo vazio: " + nomeArquivo);
			}

			return palavras;

		} catch (Exception e) {
			System.out.println("Erro ao ler o arquivo: " + e.getMessage());
			throw e;
		}
	}

	// buscar as sugestões de palavras para autocompletar

	private static List<String> buscarSugestoes(String prefixo, List<String> palavras) {
		return palavras.stream().filter(palavra -> palavra.startsWith(prefixo)).collect(Collectors.toList());
	}

}
