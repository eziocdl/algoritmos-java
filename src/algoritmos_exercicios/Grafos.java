package algoritmos_exercicios;

import java.util.*;

public class Grafos {

    private static Set<Integer>[] grafo; // Usando Set para os vizinhos

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Digite o número de salas no labirinto: ");
        int numSalas = sc.nextInt();

        grafo = new HashSet[numSalas];
        for (int i = 0; i < numSalas; i++) {
            grafo[i] = new HashSet<>();
        }

        System.out.println("Digite os corredores (pares de salas conectadas), separados por espaço:");
        System.out.println("Exemplo: 0 1 (corredor entre a sala 0 e a sala 1)");

        sc.nextLine(); // Limpar o buffer do scanner

        while (true) {
            String corredor = sc.nextLine();
            if (corredor.isEmpty()) {
                break; // Usuário terminou de digitar corredores
            }

            String[] salas = corredor.split(" ");
            int sala1 = Integer.parseInt(salas[0]);
            int sala2 = Integer.parseInt(salas[1]);

            // Verificando se as salas estão dentro do intervalo válido
            if (sala1 >= 0 && sala1 < numSalas && sala2 >= 0 && sala2 < numSalas) {
                grafo[sala1].add(sala2);
                grafo[sala2].add(sala1); // Labirinto não direcionado
            } else {
                System.out.println("Salas inválidas. Digite números entre 0 e " + (numSalas - 1) + ".");
            }
        }

        System.out.print("Digite o número da sala onde a princesa está escondida: ");
        int princesa = sc.nextInt();

        int entrada = 0; // Sala de entrada (fixa)

        List<Integer> caminho = bfs(entrada, princesa);

        if (caminho != null && !caminho.isEmpty()) { // Verificando se há caminho
            System.out.println("Caminho mais curto: " + caminho);
        } else {
            System.out.println("Não há caminho para a princesa!");
        }

        sc.close();
    }

    public static List<Integer> bfs(int inicio, int fim) {
        int numSalas = grafo.length;
        Queue<Integer> fila = new LinkedList<>();
        boolean[] visitados = new boolean[numSalas];
        int[] pais = new int[numSalas];

        fila.add(inicio);
        visitados[inicio] = true;
        pais[inicio] = -1;

        while (!fila.isEmpty()) {
            int salaAtual = fila.poll(); // Remove o elemento da fila

            if (salaAtual == fim) {
                break; // Encontrou a princesa!
            }

            for (int vizinho : grafo[salaAtual]) {
                if (!visitados[vizinho]) {
                    visitados[vizinho] = true;
                    fila.add(vizinho);
                    pais[vizinho] = salaAtual;
                }
            }
        }

        // Reconstruindo o caminho
        List<Integer> caminho = new ArrayList<>();
        int sala = fim;

        while (sala != -1) {
            caminho.add(sala);
            sala = pais[sala];
        }

        Collections.reverse(caminho);

        // Verificando se a princesa foi encontrada
        if (caminho.contains(fim)) {
            return caminho;
        } else {
            return null; // Não há caminho
        }
    }
}