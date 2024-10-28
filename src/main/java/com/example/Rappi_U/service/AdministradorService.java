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
        return administrador;
    }

    public void gestionarPedido(Pedido pedido) {
        if (pedido != null) {
            System.out.println("Gestionando pedido #" + pedido.getIdPedido());
        } else {
            throw new IllegalArgumentException("El pedido es nulo.");
        }
    }

    public void actualizarEstadoPedido(Pedido pedido, String estado) {
        if (pedido != null) {
            pedido.setEstado(estado);
            System.out.println("Estado del pedido #" + pedido.getIdPedido() + " actualizado a: " + estado);
        } else {
            throw new IllegalArgumentException("El pedido es nulo.");
        }
    }

    public Pedido findPedidoById(int idPedido) {
        Pedido pedido = pedidos.get(idPedido);
        if (pedido != null) {
            return pedido;
        } else {
            throw new IllegalArgumentException("Pedido no encontrado con ID: " + idPedido);
        }
    }

    public void addPedido(Pedido pedido) {
        pedidos.put(pedido.getIdPedido(), pedido);
    }
}
