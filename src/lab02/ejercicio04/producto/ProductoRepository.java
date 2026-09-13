package lab02.ejercicio04.producto;

import lab02.ejercicio04.general.Factory;

import java.io.IOException;
import java.nio.file.*;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public class ProductoRepository {
    private final ProductoMapper mapper = Factory.getProductoMapper();

    private Path rutaArchivo; // "../productos.txt"

    public ProductoRepository(String rutaArchivo) {
        setRutaArchivo(rutaArchivo);
    }

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

    private void validarRuta(Path ruta) {
        if (!Files.exists(ruta)) {
            throw new RuntimeException("El archivo no existe !!!");
        }
    }

    public Path getRutaArchivo() {
        return rutaArchivo;
    }

    public void setRutaArchivo(String rutaArchivo) {
        Path nuevaRuta = Paths.get(rutaArchivo).normalize();
        validarRuta(nuevaRuta);
        this.rutaArchivo = nuevaRuta;
    }
}
