package lab03.ejercicio05.producto;

import java.util.List;
import java.util.Optional;

public class ProductoMapper {
    public ProductoMapper() {}

    public Optional<Producto> toProducto(String linea) {
        String[] partesProducto = linea.split("\\s*\\|\\s*");
        if (partesProducto.length != 3) {
            return Optional.empty();
        }
        Integer codigo = Integer.parseInt(partesProducto[0]);
        String nombre = partesProducto[1];
        Double precio = Double.parseDouble(partesProducto[2]);

        Producto producto = new Producto(codigo, nombre, precio);
        if (!producto.isValid()) return Optional.empty();
        return Optional.of(producto);
    }

    public String listToString(List<Producto> listaProductos) {
        StringBuilder sb = new StringBuilder();
        for (Producto producto : listaProductos) {
            sb.append(producto.getCodigo()).append("\t|");
            sb.append(producto.getNombre()).append("\t|");
            sb.append(producto.getPrecio()).append("\n");
        }
        return sb.toString();
    }
}
