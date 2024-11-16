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
        try {
            if (producto == null) {
                throw new IllegalArgumentException("El producto no puede ser nulo.");
            }
            productos.put(producto.getIdProducto(), producto);
            return producto;
        } catch (IllegalArgumentException e) {
            throw new RuntimeException("Error al crear el producto: " + e.getMessage());
        } catch (Exception e) {
            throw new RuntimeException("Error inesperado al crear el producto: " + e.getMessage());
        }
    }

    // Buscar un producto por ID
    public Producto findProductoById(int idProducto) {
        try {
            Producto producto = productos.get(idProducto);
            if (producto == null) {
                throw new IllegalArgumentException("Producto no encontrado con ID: " + idProducto);
            }
            return producto;
        } catch (IllegalArgumentException e) {
            throw new RuntimeException("Error al buscar el producto: " + e.getMessage());
        } catch (Exception e) {
            throw new RuntimeException("Error inesperado al buscar el producto: " + e.getMessage());
        }
    }

    // Obtener todos los productos
    public List<Producto> getAllProductos() {
        try {
            return new ArrayList<>(productos.values());
        } catch (Exception e) {
            throw new RuntimeException("Error inesperado al obtener la lista de productos: " + e.getMessage());
        }
    }

    // Verificar si existe un producto
    public boolean existsProducto(int idProducto) {
        try {
            return productos.containsKey(idProducto);
        } catch (Exception e) {
            throw new RuntimeException("Error inesperado al verificar la existencia del producto: " + e.getMessage());
        }
    }

    // Eliminar un producto
    public void deleteProducto(int idProducto) {
        try {
            if (productos.remove(idProducto) == null) {
                throw new IllegalArgumentException("No se puede eliminar. Producto no encontrado con ID: " + idProducto);
            }
        } catch (IllegalArgumentException e) {
            throw new RuntimeException("Error al eliminar el producto: " + e.getMessage());
        } catch (Exception e) {
            throw new RuntimeException("Error inesperado al eliminar el producto: " + e.getMessage());
        }
    }

    // Actualizar un producto
    public Producto updateProducto(int idProducto, Producto productoActualizado) {
        try {
            if (productoActualizado == null) {
                throw new IllegalArgumentException("El producto actualizado no puede ser nulo.");
            }
            if (!productos.containsKey(idProducto)) {
                throw new IllegalArgumentException("No se puede actualizar. Producto no encontrado con ID: " + idProducto);
            }
            productos.put(idProducto, productoActualizado);
            return productoActualizado;
        } catch (IllegalArgumentException e) {
            throw new RuntimeException("Error al actualizar el producto: " + e.getMessage());
        } catch (Exception e) {
            throw new RuntimeException("Error inesperado al actualizar el producto: " + e.getMessage());
        }
    }
}
