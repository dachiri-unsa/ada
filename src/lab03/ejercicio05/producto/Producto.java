package lab03.ejercicio05.producto;

public class Producto {
    private Integer codigo;
    private String nombre;
    private Double precio;

    public Producto() {}
    public Producto(Integer codigo, String nombre, Double precio) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.precio = precio;
    }

    public boolean isValid() {
        if (
                codigo == null || nombre == null || precio == null ||
                        codigo <= 0 || precio < 0
        ) {
            return false;
        }
        return true;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
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
