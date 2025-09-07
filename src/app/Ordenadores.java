package app;

public class Ordenadores {

    public static void bubbleSort(int[] arr, boolean crescente) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if ((crescente && arr[j] > arr[j + 1]) || (!crescente && arr[j] < arr[j + 1])) {
                    int tmp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = tmp;
                }
            }
        }
    }

    public static void mergeSort(int[] arr, int esq, int dir, boolean crescente) {
        if (esq >= dir) return;
        int meio = (esq + dir) / 2;
        mergeSort(arr, esq, meio, crescente);
        mergeSort(arr, meio + 1, dir, crescente);
        merge(arr, esq, meio, dir, crescente);
    }

    private static void merge(int[] arr, int esq, int meio, int dir, boolean crescente) {
        int n1 = meio - esq + 1;
        int n2 = dir - meio;
        int[] L = new int[n1];
        int[] R = new int[n2];
        System.arraycopy(arr, esq, L, 0, n1);
        System.arraycopy(arr, meio + 1, R, 0, n2);

        int i = 0, j = 0, k = esq;
        while (i < n1 && j < n2) {
            if ((crescente && L[i] <= R[j]) || (!crescente && L[i] >= R[j])) {
                arr[k++] = L[i++];
            } else {
                arr[k++] = R[j++];
            }
        }
        while (i < n1) arr[k++] = L[i++];
        while (j < n2) arr[k++] = R[j++];
    }
}
