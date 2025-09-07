package app;

import java.util.*;

public class Matriz {
    private final int linhas;
    private final int colunas;
    private final int[][] dados;
    private Scanner sc;

    public Matriz(int linhas, int colunas) {
        this.linhas = linhas;
        this.colunas = colunas;
        this.dados = new int[linhas][colunas];
    }

    public void preencherAutomatico(int min, int max, Random rng) {
        for (int i = 0; i < linhas; i++) {
            for (int j = 0; j < colunas; j++) {
                dados[i][j] = min + rng.nextInt(max - min + 1);
            }
        }
    }

    public void remover(int linha, int coluna) {
        if (linha < 0 || linha >= linhas || coluna < 0 || coluna >= colunas)
            throw new IndexOutOfBoundsException("Posição inválida");
        dados[linha][coluna] = 0;
    }

    public void exibir() {
        for (int i = 0; i < linhas; i++) {
            System.out.print("[");
            for (int j = 0; j < colunas; j++) {
                System.out.printf("%4d", dados[i][j]);
            }
            System.out.println("  ]");
        }
    }

    public void ordenarPorLinhas(boolean crescente) {
        for (int i = 0; i < linhas; i++) {
            app.Ordenadores.bubbleSort(dados[i], crescente);
        }
    }

    public void ordenarPorColunas(boolean crescente) {
        for (int j = 0; j < colunas; j++) {
            int[] coluna = new int[linhas];
            for (int i = 0; i < linhas; i++) coluna[i] = dados[i][j];
            app.Ordenadores.mergeSort(coluna, 0, linhas - 1, crescente);
            for (int i = 0; i < linhas; i++) dados[i][j] = coluna[i];
        }
    }

    public void ordenarMatrizCompleta(boolean crescente) {
        int[] flat = new int[linhas * colunas];
        int idx = 0;
        for (int i = 0; i < linhas; i++) {
            for (int j = 0; j < colunas; j++) {
                flat[idx++] = dados[i][j];
            }
        }
        app.Ordenadores.mergeSort(flat, 0, flat.length - 1, crescente);
        idx = 0;
        for (int i = 0; i < linhas; i++) {
            for (int j = 0; j < colunas; j++) {
                dados[i][j] = flat[idx++];
            }
        }
    }

    public void preencherManual(Scanner sc) {
        this.sc = sc;
    }

    public Scanner getSc() {
        return sc;
    }

    public void setSc(Scanner sc) {
        this.sc = sc;
    }
}
