package algoritmos_exercicios;

public class CaixeiroViajante {
    static int numeroCidades = 4; // Número de cidades
    static int[][] matrizDistancias = { 
        {0, 10, 15, 20},
        {10, 0, 35, 25},
        {15, 35, 0, 30},
        {20, 25, 30, 0}
    };
    static int[][] memoizacao; // Matriz para guardar os resultados dos subproblemas
    static int todasCidadesVisitadas; // Mascara de bits para representar todas as cidades visitadas

    // Função para encontrar o caminho mínimo passando por todas as cidades
    static int encontrarCaminhoMinimo(int mascaraCidadesVisitadas, int cidadeAtual) {
        // Se todas as cidades foram visitadas, retorna para a cidade inicial
        if (mascaraCidadesVisitadas == todasCidadesVisitadas) {
            return matrizDistancias[cidadeAtual][0]; 
        }
        
        // Se o resultado para este subproblema já foi calculado, retorna o valor
        if (memoizacao[mascaraCidadesVisitadas][cidadeAtual] != -1) {
            return memoizacao[mascaraCidadesVisitadas][cidadeAtual];
        }
        
        int custoMinimo = Integer.MAX_VALUE;
        
        // Itera sobre todas as cidades para encontrar o caminho mínimo
        for (int proximaCidade = 0; proximaCidade < numeroCidades; proximaCidade++) {
            // Verifica se a próxima cidade já foi visitada
            if ((mascaraCidadesVisitadas & (1 << proximaCidade)) == 0) { 
                int novoCusto = matrizDistancias[cidadeAtual][proximaCidade] + 
                                encontrarCaminhoMinimo(mascaraCidadesVisitadas | (1 << proximaCidade), proximaCidade);
                custoMinimo = Math.min(custoMinimo, novoCusto);
            }
        }
        
        // Guarda o resultado do subproblema e retorna o custo mínimo
        return memoizacao[mascaraCidadesVisitadas][cidadeAtual] = custoMinimo;
    }

    public static void main(String[] args) {
        todasCidadesVisitadas = (1 << numeroCidades) - 1;
        memoizacao = new int[1 << numeroCidades][numeroCidades];
        
        // Inicializa a matriz de memoização com -1 (valor que indica que o subproblema não foi calculado)
        for (int i = 0; i < (1 << numeroCidades); i++) {
            for (int j = 0; j < numeroCidades; j++) {
                memoizacao[i][j] = -1;
            }
        }
        
        System.out.println("Matriz de distâncias:");
        for (int i = 0; i < numeroCidades; i++) {
            for (int j = 0; j < numeroCidades; j++) {
                System.out.print(matrizDistancias[i][j] + "\t");
            }
            System.out.println();
        }
        
        int custoTotal = encontrarCaminhoMinimo(1, 0); // Começa da cidade 0 (máscara 1 = cidade 0 visitada)
        System.out.println("\nCusto mínimo do percurso: " + custoTotal);
    }
}