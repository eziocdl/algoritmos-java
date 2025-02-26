package algoritmos_exercicios;

import java.util.InputMismatchException;
import java.util.Locale;
import java.util.Scanner;

public class CalculadoraSimples {

    public static void main(String[] args) {

        Locale.setDefault(Locale.US);

        Scanner sc = new Scanner(System.in);

        double n1 = 0;
        double n2 = 0;
        char operacao = ' ';

        while (true) { // Loop infinito

            System.out.println("Informe o primeiro número: ");

            try {
                n1 = sc.nextDouble();
            } catch (InputMismatchException e) {
                System.out.println("Entrada inválida. Digite um número.");
                sc.next();
                continue;
            }

            System.out.println("Informe o segundo número: ");
            try {
                n2 = sc.nextDouble();
            } catch (InputMismatchException e) {
                System.out.println("Entrada inválida, digite um número");
                sc.next();
                continue;
            }

            System.out.println("Qual a operação deseja fazer? (+, -, *, /, s para sair): ");
            operacao = sc.next().charAt(0);

            // Verificação da saída
            if (operacao == 's') {
                System.out.println("Encerrando a calculadora");
                break; // Sai do loop
            }

            // Cálculo da operação
            double soma = n1 + n2;
            double subtracao = n1 - n2;
            double multiplicacao = n1 * n2;
            double divisao = 0;

            switch (operacao) {

                case '+':
                    System.out.println("Resultado da soma: " + soma);
                    break;
                case '-':
                    System.out.println("Resultado da subtação: " + subtracao);
                    break;
                case '*':
                    System.out.println("Resultado da multiplicacao: " + multiplicacao);
                    break;
                case '/':

                    if (n2 == 0) {
                        System.out.println("Operação inválida, escolha segundo número maior que zero ou positivo");
                    } else {

                        divisao = n1 / n2;

                        System.out.println("Resultado da divisão: " + divisao);
                    }
                    break;

                default:

                    System.out.println("Operação inválida");

                    System.out.println("Deseja tentar novamente? (s/n)");

                    char tentarNovamente = sc.next().charAt(0);

                    if (tentarNovamente == 'n') {
                        break; // Encerra o programa se o usuário digitar 'n'
                    }

            }
        }

        sc.close();

    }

}