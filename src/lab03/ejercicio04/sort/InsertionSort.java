package lab03.ejercicio04.sort;

public class InsertionSort implements SortAlgorithm {
    @Override
    public void sort(int[] datos) {
        for  (int i = 1; i < datos.length; i++) {
            for (int j = i; j > 0; j--) {
                if (datos[j] < datos[j-1]) {
                    int aux = datos[j];
                    datos[j] = datos[j-1];
                    datos[j-1] = aux;
                }
                else break;
            }
        }
    }
}
