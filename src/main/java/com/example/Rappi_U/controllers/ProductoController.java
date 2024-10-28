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
        return productoService.createProducto(producto);
    }

    // Endpoint para obtener un producto por ID
    @GetMapping("/{id}")
    public Producto getProducto(@PathVariable int id) {
        return productoService.findProductoById(id);
    }

    // Endpoint para listar todos los productos
    @GetMapping
    public List<Producto> getAllProductos() {
        return productoService.getAllProductos();
    }

    // Endpoint para ver los detalles de un producto
    @GetMapping("/{id}/detalles")
    public String verDetalles(@PathVariable int id) {
        Producto producto = productoService.findProductoById(id);
        return producto.getNombre() + ": $" + producto.getPrecio() + " - " + producto.getDescripcion();
    }

    // Endpoint para agregar el producto al pedido
    @PostMapping("/{id}/agregarAlPedido")
    public String agregarAlPedido(@PathVariable int id) {
        Producto producto = productoService.findProductoById(id);
        producto.agregarAlPedido();
        return "Producto " + producto.getNombre() + " agregado al pedido.";
    }
}

