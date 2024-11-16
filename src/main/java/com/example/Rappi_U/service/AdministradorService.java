package com.example.Rappi_U.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.example.Rappi_U.models.Administrador;
import com.example.Rappi_U.models.Pedido;

@Service
public class AdministradorService {

    private Map<Integer, Pedido> pedidos = new HashMap<>();

    public Administrador createAdministrador(Administrador administrador) {
        try {
            if (administrador == null) {
                throw new IllegalArgumentException("El administrador no puede ser nulo.");
            }
            return administrador;
        } catch (IllegalArgumentException e) {
            throw new RuntimeException("Error al crear el administrador: " + e.getMessage());
        } catch (Exception e) {
            throw new RuntimeException("Error inesperado al crear el administrador: " + e.getMessage());
        }
    }

    public void gestionarPedido(Pedido pedido) {
        try {
            if (pedido == null) {
                throw new IllegalArgumentException("El pedido no puede ser nulo.");
            }
            System.out.println("Gestionando pedido #" + pedido.getIdPedido());
        } catch (IllegalArgumentException e) {
            throw new RuntimeException("Error al gestionar el pedido: " + e.getMessage());
        } catch (Exception e) {
            throw new RuntimeException("Error inesperado al gestionar el pedido: " + e.getMessage());
        }
    }

    public void actualizarEstadoPedido(Pedido pedido, String estado) {
        try {
            if (pedido == null) {
                throw new IllegalArgumentException("El pedido no puede ser nulo.");
            }
            if (estado == null || estado.isEmpty()) {
                throw new IllegalArgumentException("El estado no puede ser nulo o vacío.");
            }
            pedido.setEstado(estado);
            System.out.println("Estado del pedido #" + pedido.getIdPedido() + " actualizado a: " + estado);
        } catch (IllegalArgumentException e) {
            throw new RuntimeException("Error al actualizar el estado del pedido: " + e.getMessage());
        } catch (Exception e) {
            throw new RuntimeException("Error inesperado al actualizar el estado del pedido: " + e.getMessage());
        }
    }

    public Pedido findPedidoById(int idPedido) {
        try {
            Pedido pedido = pedidos.get(idPedido);
            if (pedido == null) {
                throw new IllegalArgumentException("Pedido no encontrado con ID: " + idPedido);
            }
            return pedido;
        } catch (IllegalArgumentException e) {
            throw new RuntimeException("Error al buscar el pedido: " + e.getMessage());
        } catch (Exception e) {
            throw new RuntimeException("Error inesperado al buscar el pedido: " + e.getMessage());
        }
    }

    public void addPedido(Pedido pedido) {
        try {
            if (pedido == null) {
                throw new IllegalArgumentException("El pedido no puede ser nulo.");
            }
            pedidos.put(pedido.getIdPedido(), pedido);
        } catch (IllegalArgumentException e) {
            throw new RuntimeException("Error al agregar el pedido: " + e.getMessage());
        } catch (Exception e) {
            throw new RuntimeException("Error inesperado al agregar el pedido: " + e.getMessage());
        }
    }
}
