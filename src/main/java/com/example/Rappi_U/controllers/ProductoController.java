package com.example.Rappi_U.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Rappi_U.models.Producto;
import com.example.Rappi_U.service.ProductoService;

@RestController
@RequestMapping("api/producto")
public class ProductoController {

    @Autowired
    private ProductoService productoService;

    // Endpoint para crear un producto
    @PostMapping
    public Producto createProducto(@RequestBody Producto producto) {
        try {
            if (producto == null || producto.getNombre() == null || producto.getPrecio() <= 0) {
                throw new IllegalArgumentException("Datos del producto incompletos o inválidos.");
            }
            return productoService.createProducto(producto);
        } catch (IllegalArgumentException e) {
            throw new RuntimeException("Error al crear el producto: " + e.getMessage());
        } catch (Exception e) {
            throw new RuntimeException("Error inesperado al crear el producto: " + e.getMessage());
        }
    }

    // Endpoint para obtener un producto por ID
    @GetMapping("/{id}")
    public Producto getProducto(@PathVariable int id) {
        try {
            Producto producto = productoService.findProductoById(id);
            if (producto == null) {
                throw new IllegalArgumentException("Producto no encontrado con ID: " + id);
            }
            return producto;
        } catch (IllegalArgumentException e) {
            throw new RuntimeException("Error al obtener el producto: " + e.getMessage());
        } catch (Exception e) {
            throw new RuntimeException("Error inesperado al obtener el producto: " + e.getMessage());
        }
    }

    // Endpoint para listar todos los productos
    @GetMapping
    public List<Producto> getAllProductos() {
        try {
            return productoService.getAllProductos();
        } catch (Exception e) {
            throw new RuntimeException("Error al listar los productos: " + e.getMessage());
        }
    }

    // Endpoint para ver los detalles de un producto
    @GetMapping("/{id}/detalles")
    public String verDetalles(@PathVariable int id) {
        try {
            Producto producto = productoService.findProductoById(id);
            if (producto == null) {
                throw new IllegalArgumentException("Producto no encontrado con ID: " + id);
            }
            return producto.getNombre() + ": $" + producto.getPrecio() + " - " + producto.getDescripcion();
        } catch (IllegalArgumentException e) {
            return "Error al obtener detalles del producto: " + e.getMessage();
        } catch (Exception e) {
            return "Error inesperado al obtener detalles del producto: " + e.getMessage();
        }
    }

    // Endpoint para agregar el producto al pedido
    @PostMapping("/{id}/agregarAlPedido")
    public String agregarAlPedido(@PathVariable int id) {
        try {
            Producto producto = productoService.findProductoById(id);
            if (producto == null) {
                throw new IllegalArgumentException("Producto no encontrado con ID: " + id);
            }
            producto.agregarAlPedido();
            return "Producto " + producto.getNombre() + " agregado al pedido.";
        } catch (IllegalArgumentException e) {
            return "Error al agregar el producto al pedido: " + e.getMessage();
        } catch (Exception e) {
            return "Error inesperado al agregar el producto al pedido: " + e.getMessage();
        }
    }
}