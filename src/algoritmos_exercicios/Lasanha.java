package algoritmos_exercicios;

import java.util.Locale;
import java.util.Scanner;

public class Lasanha {

    public static void main(String[] args) {

        Locale.setDefault(Locale.US);

        Scanner sc = new Scanner(System.in);

        System.out.println("Tempo esperado de forno: " + expectedMinutesInOven());

        System.out.println("Informe a quantidade de camadas: ");
        int camadas = sc.nextInt();
        System.out.println("Camadas da Lasanha: " + preparationTimeInMinutes(camadas));

        System.out.println("Quanto tempo faz que a Lasanha está no forno? ");
        int tempoForno = sc.nextInt();
        System.out.println("Tempo restante do forno: " + remainingMinutesInOven(tempoForno));

        System.out.println("Tempo total do Trabalho: " + totalTimeInMinutes(camadas, tempoForno));

        sc.close();
    }

    public static int expectedMinutesInOven() {
        return 40;
    }

    public static int preparationTimeInMinutes(int camadas) {
        return camadas * 2;
    }

    public static int remainingMinutesInOven(int tempoForno) {
        return 40 - tempoForno;
    }

    public static int totalTimeInMinutes(int camadas, int tempoForno) {
        return preparationTimeInMinutes(camadas) + tempoForno;
    }

}