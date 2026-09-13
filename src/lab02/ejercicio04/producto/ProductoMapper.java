package lab02.ejercicio04.producto;

import java.util.List;
import java.util.Optional;

public class ProductoMapper {
    public ProductoMapper() {}

    public Optional<Producto> toProducto(String linea) {
        String[] partesProducto = linea.split("\\s*\\|\\s*");
        if (partesProducto.length != 3) {
            return Optional.empty();
        }
        Integer id = Integer.parseInt(partesProducto[0]);
        String nombre = partesProducto[1];
        Double precio = Double.parseDouble(partesProducto[2]);

        Producto producto = new Producto(id, nombre, precio);
        if (!producto.isValid()) return Optional.empty();
        return Optional.of(producto);
    }
}
