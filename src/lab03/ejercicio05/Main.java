package lab03.ejercicio05;

import lab03.ejercicio05.producto.Producto;
import lab03.ejercicio05.producto.ProductoRepository;
import lab03.ejercicio05.sort.MergeSort;
import lab03.ejercicio05.sort.QuickSort;
import lab03.ejercicio05.sort.SortAlgorithm;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        ProductoRepository productoRepository = new ProductoRepository();

        // SortAlgorithm sortAlgorithm = new MergeSort();
        SortAlgorithm sortAlgorithm = new QuickSort();

        List<Producto> productos = productoRepository.findAll();

        sortAlgorithm.sort(productos, Comparator.comparing(Producto::getPrecio).reversed());

        productoRepository.exportarProductos(productos);
    }
}
