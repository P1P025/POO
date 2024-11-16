package com.example.Rappi_U.service;
import java.util.List;

import com.example.Rappi_U.models.Producto;

public interface IProductoService {

    // Crear un nuevo producto
    Producto createProducto(Producto producto);

    // Buscar un producto por ID
    Producto findProductoById(int idProducto);

    // Obtener todos los productos
    List<Producto> getAllProductos();

    // Verificar si existe un producto
    boolean existsProducto(int idProducto);

    // Eliminar un producto
    void deleteProducto(int idProducto);

    // Actualizar un producto
    Producto updateProducto(int idProducto, Producto productoActualizado);
}

