package algoritmos_exercicios;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AutoCompletar {

    public static void main(String[] args) {

        // Ajuste no caminho do arquivo para carregá-lo corretamente do classpath
        List<String> palavras = lerArquivo("palavras.txt");

        Scanner sc = new Scanner(System.in);

        while (true) {

            System.out.println("Digite um prefixo (ou sair para encerrar): ");
            String prefixo = sc.nextLine();

            if (prefixo.equalsIgnoreCase("sair")) {
                break;
            }

            List<String> sugestoes = buscarSugestoes(prefixo, palavras);

            if (sugestoes.isEmpty()) {
                System.out.println("Nenhuma sugestão encontrada.");
            } else {
                System.out.println("Sugestões: " + sugestoes);
            }

        }

        sc.close();
    }

    public static List<String> lerArquivo(String nomeArquivo) {
        List<String> palavras = new ArrayList<>();

        try {
            // Obtém o recurso dentro do classpath
            InputStream inputStream = AutoCompletar.class.getClassLoader().getResourceAsStream(nomeArquivo);

            if (inputStream == null) {
                System.out.println("Arquivo não encontrado: " + nomeArquivo);
                return palavras;
            }

            Scanner scanner = new Scanner(inputStream);

            while (scanner.hasNextLine()) {
                palavras.add(scanner.nextLine());
            }

            scanner.close();
        } catch (Exception e) {
            System.out.println("Erro ao ler o arquivo: " + e.getMessage());
        }

        return palavras;
    }

    public static List<String> buscarSugestoes(String prefixo, List<String> palavras) {
        List<String> sugestoes = new ArrayList<>();

        for (String palavra : palavras) {
            if (palavra.startsWith(prefixo)) {
                sugestoes.add(palavra);
            }
        }

        return sugestoes;
    }
}
