package lab03.ejercicio04.sort;

public class QuickSort implements SortAlgorithm {
    @Override
    public void sort(int[] datos) {
        quickSort(datos, 0, datos.length - 1);
    }
    public void quickSort(int[] datos, int inicio, int fin) {
        if (inicio < fin) {
            int pivote = particion(datos, inicio, fin);

            quickSort(datos, inicio, pivote - 1);
            quickSort(datos, pivote + 1, fin);
        }
    }

    private int particion(int[] datos, int inicio, int fin) {
        int pivote = datos[fin];
        int i = inicio - 1;

        for (int j = inicio; j < fin; j++) {
            if (datos[j] <= pivote) {
                i++;

                int aux = datos[i];
                datos[i] = datos[j];
                datos[j] = aux;
            }
        }

        int aux = datos[i + 1];
        datos[i + 1] = datos[fin];
        datos[fin] = aux;

        return i + 1;
    }
}
