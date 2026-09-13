package lab02.ejercicio04.producto;

import java.util.List;

public class ProductoSortService {
    public ProductoSortService() {}

    public void selectionSort(List<Producto> productos) {
        int comparaciones = 0;
        int intercambios = 0;
        for (int i = 0; i < productos.size() - 1; i++) {
            int indiceMenor = i;
            for (int j = i + 1; j < productos.size(); j++) {
                comparaciones++;
                if (productos.get(j).getPrecio() < productos.get(indiceMenor).getPrecio()) {
                    indiceMenor = j;
                }
            } if (indiceMenor != i) {
                Producto temporal = productos.get(i);
                productos.set(i, productos.get(indiceMenor));
                productos.set(indiceMenor, temporal);
                intercambios++;
            }
        }
        mostrarDatosSort(comparaciones, intercambios);
    }
    public void insertionSort(List<Producto> productos) {
        int comparaciones = 0;
        int intercambios = 0;
        for (int i = 1; i < productos.size(); i++) {
            for (int j = i; j > 0; j--) {
                comparaciones++;
                if (productos.get(j).getPrecio() < productos.get(j - 1).getPrecio()) {
                    Producto temporal = productos.get(j);
                    productos.set(j, productos.get(j - 1));
                    productos.set(j - 1, temporal);
                    intercambios++;
                } else break;
            }
        }
        mostrarDatosSort(comparaciones, intercambios);
    }
    private static void mostrarDatosSort(int comparaciones, int intercambios) {
        System.out.println("\n--- RESULTADO SORT ---");
        System.out.println("Comparaciones: " + comparaciones);
        System.out.println("Intercambios: " + intercambios);
    }

}
