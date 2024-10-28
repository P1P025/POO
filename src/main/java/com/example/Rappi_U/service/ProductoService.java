package com.example.Rappi_U.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.example.Rappi_U.models.Producto;

@Service
public class ProductoService {
    
    private Map<Integer, Producto> productos = new HashMap<>();

    // Crear un nuevo producto
    public Producto createProducto(Producto producto) {
        if (producto == null) {
            throw new IllegalArgumentException("El producto no puede ser nulo.");
        }
        productos.put(producto.getIdProducto(), producto);
        return producto;
    }

    // Buscar un producto por ID
    public Producto findProductoById(int idProducto) {
        Producto producto = productos.get(idProducto);
        if (producto != null) {
            return producto;
        } else {
            throw new IllegalArgumentException("Producto no encontrado con ID: " + idProducto);
        }
    }

    // Obtener todos los productos
    public List<Producto> getAllProductos() {
        return new ArrayList<>(productos.values());
    }

    // Verificar si existe un producto
    public boolean existsProducto(int idProducto) {
        return productos.containsKey(idProducto);
    }

    // Eliminar un producto
    public void deleteProducto(int idProducto) {
        if (productos.remove(idProducto) == null) {
            throw new IllegalArgumentException("No se puede eliminar. Producto no encontrado con ID: " + idProducto);
        }
    }

    // Actualizar un producto
    public Producto updateProducto(int idProducto, Producto productoActualizado) {
        if (!productos.containsKey(idProducto)) {
            throw new IllegalArgumentException("No se puede actualizar. Producto no encontrado con ID: " + idProducto);
        }
        productos.put(idProducto, productoActualizado);
        return productoActualizado;
    }
}