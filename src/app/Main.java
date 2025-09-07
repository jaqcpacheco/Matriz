package app;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random rng = new Random();

        Matriz matriz = null;

        while (true) {
            System.out.println("\n MENU MATRIZ ");
            System.out.println("1 - Criar nova matriz");
            System.out.println("2 - Preencher manualmente");
            System.out.println("3 - Preencher automaticamente");
            System.out.println("4 - Exibir matriz");
            System.out.println("5 - Remover elemento");
            System.out.println("6 - Ordenar por linhas");
            System.out.println("7 - Ordenar por colunas");
            System.out.println("8 - Ordenar matriz completa");
            System.out.println("0 - Sair");
            System.out.print("Escolha: ");

            int opcao = sc.nextInt();

            try {
                switch (opcao) {
                    case 1 -> {
                        System.out.print("Linhas: ");
                        int l = sc.nextInt();
                        System.out.print("Colunas: ");
                        int c = sc.nextInt();
                        matriz = new Matriz(l, c);
                        System.out.println("Matriz criada com sucesso!");
                    }
                    case 2 -> {
                        requireMatrix(matriz);
                        matriz.preencherManual(sc);
                        System.out.println("Matriz preenchida manualmente!");
                    }
                    case 3 -> {
                        requireMatrix(matriz);
                        System.out.print("Valor mínimo: ");
                        int min = sc.nextInt();
                        System.out.print("Valor máximo: ");
                        int max = sc.nextInt();
                        matriz.preencherAutomatico(min, max, rng);
                        System.out.println("Matriz preenchida automaticamente!");
                    }
                    case 4 -> {
                        requireMatrix(matriz);
                        System.out.println("Matriz atual:");
                        matriz.exibir();
                    }
                    case 5 -> {
                        requireMatrix(matriz);
                        System.out.print("Linha: ");
                        int l = sc.nextInt();
                        System.out.print("Coluna: ");
                        int c = sc.nextInt();
                        matriz.remover(l, c);
                        System.out.println("Elemento removido!");
                    }
                    case 6 -> {
                        requireMatrix(matriz);
                        matriz.ordenarPorLinhas(true);
                        System.out.println("Matriz ordenada por linhas!");
                    }
                    case 7 -> {
                        requireMatrix(matriz);
                        matriz.ordenarPorColunas(true);
                        System.out.println("Matriz ordenada por colunas!");
                    }
                    case 8 -> {
                        requireMatrix(matriz);
                        matriz.ordenarMatrizCompleta(true);
                        System.out.println("Matriz ordenada como vetor!");
                    }
                    case 0 -> {
                        System.out.println("Encerrando programa...");
                        return;
                    }
                    default -> System.out.println("Opção inválida!");
                }
            } catch (Exception e) {
                System.out.println("Erro: " + e.getMessage());
            }
        }
    }

    private static void requireMatrix(Matriz m) {
        if (m == null) throw new IllegalStateException("Crie a matriz primeiro (opção 1).");
    }
}
