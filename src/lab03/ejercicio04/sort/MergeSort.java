package lab03.ejercicio04.sort;

public class MergeSort implements SortAlgorithm {
    @Override
    public void sort(int[] datos) {
        mergeSort(datos, 0, datos.length - 1);
    }

    private void mergeSort(int[] datos, int inicio, int fin) {
        if (inicio < fin) {
            int medio = inicio + (fin - inicio) / 2;

            mergeSort(datos, inicio, medio);
            mergeSort(datos, medio + 1, fin);

            merge(datos, inicio, medio, fin);
        }
    }

    private void merge(int[] datos, int inicio, int medio, int fin) {
        int[] auxiliar = new int[fin - inicio + 1];

        int i = inicio;
        int j = medio + 1;
        int k = 0;

        while (i <= medio && j <= fin) {
            if (datos[i] <= datos[j]) {
                auxiliar[k++] = datos[i++];
            } else {
                auxiliar[k++] = datos[j++];
            }
        }

        while (i <= medio) { auxiliar[k++] = datos[i++]; }
        while (j <= fin) { auxiliar[k++] = datos[j++]; }

        for (int x = 0; x < auxiliar.length; x++) {
            datos[inicio + x] = auxiliar[x];
        }
    }

}
