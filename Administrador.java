public class Administrador extends Usuario {

    public Administrador(String nombre, String email, String password) {
        super(nombre, email, password, "admin");
    }

    public void gestionarPedido(Pedido pedido) {
        System.out.println("Gestionando pedido #" + pedido.getIdPedido());
    }

    public void actualizarEstadoPedido(Pedido pedido, String estado) {
        pedido.setEstado(estado);
        System.out.println("Estado del pedido #" + pedido.getIdPedido() + " actualizado a: " + estado);
    }
}

