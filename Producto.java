public class Producto {
    private int idProducto;
    private String nombre;
    private int precio;
    private String descripcion;

    public Producto(int idProducto, String nombre, int precio, String descripcion) {
        this.idProducto = idProducto;
        this.nombre = nombre;
        this.precio = precio;
        this.descripcion = descripcion;
    }

    public int getIdProducto() {
        return idProducto;
    }

    public String getNombre() {
        return nombre;
    }

    public int getPrecio() {
        return precio;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void agregarAlPedido() {
        System.out.println("Producto " + nombre + " agregado al pedido.");
    }

    public void verDetalles() {
        System.out.println("Producto: " + nombre + ", Precio: $" + precio + ", Descripción: " + descripcion);
    }
}

