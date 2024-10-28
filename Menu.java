import java.util.List;

public class Menu {
    private List<Producto> productos;

    public Menu(List<Producto> productos) {
        this.productos = productos;
    }

    public void verMenu() {
        System.out.println("Menú de productos:");
        for (Producto producto : productos) {
            producto.verDetalles();
        }
    }
}
