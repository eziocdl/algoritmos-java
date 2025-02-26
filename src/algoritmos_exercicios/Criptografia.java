package algoritmos_exercicios;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Scanner;

public class Criptografia {

    public static void main(String[] args) {

        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        String palavras;

        while (true) {

            System.out.println("Insira a palavra que quer criptografar, sem acento ou ç: ");
            palavras = sc.nextLine().toUpperCase();

            if (palavras.matches("[A-Z]+")) {
                break;
            } else {
                System.out.println("Digite somente letras sem acento ou ç.");
            }
        }

        Map<Character, Integer> alfabeto = GerarCriptografia();

        System.out.print("O nome " + palavras + " corresponde a: ");
        for (int i = 0; i < palavras.length(); i++) {
            char letra = palavras.charAt(i);
            int valorAtual = alfabeto.get(letra);
            System.out.print(valorAtual); // Imprime o valor numérico sem espaço
        }
        System.out.println(); // Quebra de linha no final

        sc.close();
    }

    private static Map<Character, Integer> GerarCriptografia() {
        Map<Character, Integer> alfabeto = new HashMap<>();
        alfabeto.put('A', 1);
        alfabeto.put('B', 2);
        alfabeto.put('C', 3);
        alfabeto.put('D', 4);
        alfabeto.put('E', 5);
        alfabeto.put('F', 6);
        alfabeto.put('G', 7);
        alfabeto.put('H', 8);
        alfabeto.put('I', 9);
        alfabeto.put('J', 10);
        alfabeto.put('K', 11);
        alfabeto.put('L', 12);
        alfabeto.put('M', 13);
        alfabeto.put('N', 14);
        alfabeto.put('O', 15);
        alfabeto.put('P', 16);
        alfabeto.put('Q', 17);
        alfabeto.put('R', 18);
        alfabeto.put('S', 19);
        alfabeto.put('T', 20);
        alfabeto.put('U', 21);
        alfabeto.put('V', 22);
        alfabeto.put('W', 23);
        alfabeto.put('X', 24);
        alfabeto.put('Y', 25);
        alfabeto.put('Z', 26);
        return alfabeto;
    }
}