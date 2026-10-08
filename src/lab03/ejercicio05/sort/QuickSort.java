package lab03.ejercicio05.sort;

import java.util.Comparator;
import java.util.List;

public class QuickSort implements SortAlgorithm {
    @Override
    public <T> void sort(List<T> datos, Comparator<T> comparator) {
        quickSort(datos, 0, datos.size() - 1, comparator);
    }
    public <T> void quickSort(List<T> datos, int inicio, int fin, Comparator<T> comparator) {
        if (inicio < fin) {
            int pivote = particion(datos, inicio, fin, comparator);

            quickSort(datos, inicio, pivote - 1, comparator);
            quickSort(datos, pivote + 1, fin, comparator);
        }
    }

    private <T> int particion(List<T> datos, int inicio, int fin, Comparator<T> comparator) {
        T pivote = datos.get(fin);
        int i = inicio - 1;

        for (int j = inicio; j < fin; j++) {
            if (comparator.compare(datos.get(j), pivote) <= 0) {
                i++;

                T aux = datos.get(i);
                datos.set(i, datos.get(j));
                datos.set(j, aux);
            }
        }

        T aux = datos.get(i+1);
        datos.set(i + 1, datos.get(fin));
        datos.set(fin, aux);

        return i + 1;
    }
}
