package lab02.ejercicio04.general;

import lab02.ejercicio04.csv.CsvService;
import lab02.ejercicio04.producto.ProductoMapper;
import lab02.ejercicio04.producto.ProductoRepository;
import lab02.ejercicio04.producto.ProductoSortService;

public class ServiceLocator {

    private static final ProductoRepository productoRepository;
    private static final ProductoMapper productoMapper;
    private static final ProductoSortService productoSortService;
    private static final CsvService csvService;

    static {
        productoMapper = new ProductoMapper();
        productoRepository = new ProductoRepository("src/lab02/ejercicio04/productos.txt");
        productoSortService = new ProductoSortService();
        csvService = new CsvService("src/lab02/ejercicio04/productos.csv");
    }

    public static ProductoRepository getProductoRepository() {
        return productoRepository;
    }
    public static ProductoMapper getProductoMapper() {
        return productoMapper;
    }
    public static ProductoSortService getProductoSortService() {
        return productoSortService;
    }
    public static CsvService getCsvService() {
        return csvService;
    }
}
