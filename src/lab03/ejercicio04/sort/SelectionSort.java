package lab03.ejercicio04.sort;

public class SelectionSort implements SortAlgorithm {
    @Override
    public void sort(int[] datos) {
        for  (int i = 0; i < datos.length; i++) {
            int posicionMenor = i;
            for(int j = i + 1; j < datos.length; j++) {
                if(datos[posicionMenor] > datos[j]) {
                    posicionMenor = j;
                }
            }
            if(posicionMenor != i) {
                int aux = datos[i];
                datos[i] = datos[posicionMenor];
                datos[posicionMenor] = aux;
            }
        }
    }
}
