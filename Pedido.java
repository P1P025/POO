import java.util.List;

public class Pedido {
    private int idPedido;
    private String estado;
    private List<Producto> productos;
    private Usuario cliente;

    public Pedido(int idPedido, List<Producto> productos, Usuario cliente) {
        this.idPedido = idPedido;
        this.productos = productos;
        this.cliente = cliente;
        this.estado = "Pendiente";
    }

    public int getIdPedido() {
        return idPedido;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public void crearPedido() {
        System.out.println("Pedido creado para el cliente: " + cliente.getNombre());
    }

    public void actualizarEstado(String nuevoEstado) {
        this.estado = nuevoEstado;
        System.out.println("El estado del pedido ha sido actualizado a: " + nuevoEstado);
    }
}
