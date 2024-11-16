package com.example.Rappi_U.service;

import com.example.Rappi_U.models.Administrador;
import com.example.Rappi_U.models.Pedido;

public interface IAdministradorService {

    // Crear un nuevo administrador
    Administrador createAdministrador(Administrador administrador);

    // Gestionar un pedido
    void gestionarPedido(Pedido pedido);

    // Actualizar el estado de un pedido
    void actualizarEstadoPedido(Pedido pedido, String estado);

    // Buscar un pedido por ID
    Pedido findPedidoById(int idPedido);

    // Agregar un pedido
    void addPedido(Pedido pedido);
}