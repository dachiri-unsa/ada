package lab02.ejercicio04;

import lab02.ejercicio04.general.ServiceLocator;
import lab02.ejercicio04.producto.Producto;

import java.time.Duration;
import java.util.List;

public class Main {
    public static void main(String args[]) {
        System.out.println("Ejercicio4");
        long inicio = System.nanoTime();
        try {
            OrdenamientoProductos();
        }
        catch (Exception e) {
            System.err.println("Error al ejecutar OrdenamientoProductos: \n" + e);
        }
        long fin = System.nanoTime();
        Duration duracion = Duration.ofNanos(fin - inicio);
        System.out.println("Tiempo: " + duracion.toMillis() + " ms");
    }

    private static void OrdenamientoProductos() throws Exception {
        List<Producto> productos = ServiceLocator.getProductoRepository().findAll();
        // Factory.getProductoSortService().insertionSort(productos);
        ServiceLocator.getProductoSortService().selectionSort(productos);
        ServiceLocator.getCsvService().exportarProductos(productos);
    }
}
z