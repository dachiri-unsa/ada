package lab03.ejercicio05.sort;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class MergeSort implements SortAlgorithm {
    @Override
    public <T> void sort(List<T> datos, Comparator<T> comparator) {
        mergeSort(datos, 0, datos.size() - 1, comparator);
    }

    private <T> void mergeSort(List<T> datos, int inicio, int fin, Comparator<T> comparator) {
        if (inicio < fin) {
            int medio = inicio + (fin - inicio) / 2;

            mergeSort(datos, inicio, medio, comparator);
            mergeSort(datos, medio + 1, fin, comparator);

            merge(datos, inicio, medio, fin, comparator);
        }
    }

    private <T> void merge(List<T> datos, int inicio, int medio, int fin, Comparator<T> comparator) {
        List<T> auxiliar = new ArrayList<>(fin - inicio + 1);

        int i = inicio;
        int j = medio + 1;

        while (i <= medio && j <= fin) {
            if (comparator.compare(datos.get(i), datos.get(j)) <= 0) {
                auxiliar.add(datos.get(i++));
            } else {
                auxiliar.add(datos.get(j++));
            }
        }

        while (i <= medio) { auxiliar.add(datos.get(i++)); }
        while (j <= fin) { auxiliar.add(datos.get(j++)); }

        for (int x = 0; x < auxiliar.size(); x++) {
            datos.set(inicio + x, auxiliar.get(x));
        }
    }
}
