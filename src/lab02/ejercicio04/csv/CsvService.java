package lab02.ejercicio04.csv;

import lab02.ejercicio04.producto.Producto;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class CsvService {
    private String csvPathDefault;

    public CsvService(String rutaDefault) {
        csvPathDefault = rutaDefault;
    }

    public void exportarProductos(List<Producto> listaProductos) throws Exception {
        StringBuilder sb = new StringBuilder();
        for (Producto producto : listaProductos) {
            sb.append(producto.getId()).append(",");
            sb.append(producto.getNombre()).append(",");
            sb.append(producto.getPrecio()).append("\n");
        }
        Path ruta = Path.of(csvPathDefault);

        Files.writeString(ruta, sb.toString());
    }

}
