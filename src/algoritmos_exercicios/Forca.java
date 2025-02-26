package algoritmos_exercicios;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;

public class Forca {

    private static Scanner sc = new Scanner(System.in); // Scanner global

    public static void main(String[] args) {
        Forca jogo = new Forca();
        jogo.jogar();
        sc.close(); // Fecha o Scanner ao final do jogo
    }

    private ArrayList<String> palavras = new ArrayList<>();
    private String palavraSecreta;
    private StringBuilder palavraExibida;
    private Set<Character> letrasAdivinhadas;

    public Forca() {
        palavras.add("java");
        palavras.add("programacao");
        palavras.add("computador");
        palavras.add("desenvolvedor");
        palavras.add("codigo");

        Random random = new Random();
        int indice = random.nextInt(palavras.size());
        palavraSecreta = palavras.get(indice);

        // Inicializa a palavra exibida com underscores
        palavraExibida = new StringBuilder("_".repeat(palavraSecreta.length()));
        letrasAdivinhadas = new HashSet<>();
    }

    public void exibirPalavra() {
        System.out.println("Palavra: " + palavraExibida.toString());
    }

    public char obterPalpite() {
        System.out.print("Digite uma letra: ");
        String input = sc.next().toLowerCase();

        if (input.isEmpty()) {
            System.out.println("Entrada inválida! Tente novamente.");
            return obterPalpite();
        }

        char letra = input.charAt(0);
        if (!Character.isLetter(letra)) {
            System.out.println("Apenas letras são permitidas. Tente novamente.");
            return obterPalpite();
        }

        return letra;
    }

    private boolean verificarPalpite(char letra) {
        return palavraSecreta.contains(String.valueOf(letra));
    }

    public void jogar() {
        int chances = 6;

        while (chances > 0 && palavraExibida.toString().contains("_")) {
            exibirPalavra();
            char palpite = obterPalpite();

            if (letrasAdivinhadas.contains(palpite)) {
                System.out.println("Você já tentou essa letra! Escolha outra.");
                continue;
            }

            letrasAdivinhadas.add(palpite);

            if (verificarPalpite(palpite)) {
                // Atualiza a palavra exibida com a letra correta
                for (int i = 0; i < palavraSecreta.length(); i++) {
                    if (palavraSecreta.charAt(i) == palpite) {
                        palavraExibida.setCharAt(i, palpite);
                    }
                }
                System.out.println("Letra correta!");
            } else {
                chances--;
                System.out.println("Letra incorreta. Chances restantes: " + chances);
                desenharForca(6 - chances);
            }
        }

        // Verifica se o jogador venceu ou perdeu
        if (!palavraExibida.toString().contains("_")) {
            System.out.println("Parabéns! Você acertou a palavra: " + palavraSecreta);
        } else {
            System.out.println("Você perdeu! A palavra era: " + palavraSecreta);
        }
    }

    private void desenharForca(int erros) {
        switch (erros) {
            case 1 -> System.out.println("""
                  _______
                 |       |
                 |       O
                 |
                 |
                 |
                _|__________
                """);
            case 2 -> System.out.println("""
                  _______
                 |       |
                 |       O
                 |       |
                 |
                 |
                _|__________
                """);
            case 3 -> System.out.println("""
                  _______
                 |       |
                 |       O
                 |      /|
                 |
                 |
                _|__________
                """);
            case 4 -> System.out.println("""
                  _______
                 |       |
                 |       O
                 |      /|\\
                 |
                 |
                _|__________
                """);
            case 5 -> System.out.println("""
                  _______
                 |       |
                 |       O
                 |      /|\\
                 |      /
                 |
                _|__________
                """);
            case 6 -> System.out.println("""
                  _______
                 |       |
                 |       O
                 |      /|\\
                 |      / \\
                 |
                _|__________
                """);
        }
    }
}
