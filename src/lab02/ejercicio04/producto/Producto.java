package lab02.ejercicio04.producto;

public class Producto {
    private Integer id;
    private String nombre;
    private Double precio;

    public Producto() {}
    public Producto(Integer id, String nombre, Double precio) {
        this.id = id;
        this.nombre = nombre;
        this.precio = precio;
    }

    public boolean isValid() {
        if (
                id == null || nombre == null || precio == null ||
                id <= 0 || precio < 0
        ) {
            return false;
        }
        return true;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }
}
