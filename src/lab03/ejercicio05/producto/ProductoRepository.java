package lab03.ejercicio05.producto;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ProductoRepository {
    private final ProductoMapper mapper = new ProductoMapper();

    private final Path rutaArchivo = Path.of("src/lab03/ejercicio05/productos.txt");
    private final Path rutaDestino = Path.of("src/lab03/ejercicio05/productosOrdenados.txt");

    public List<Producto> findAll() {
        try (Stream<String> lineas = Files.lines(rutaArchivo)) {
            return lineas
                    .map(mapper::toProducto)
                    .flatMap(Optional::stream)
                    .collect(Collectors.toList());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void exportarProductos(List<Producto> listaProductos) {
        try {
            Files.writeString(rutaDestino, mapper.listToString(listaProductos));
        }
        catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
