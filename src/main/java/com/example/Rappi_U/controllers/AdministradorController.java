package com.example.Rappi_U.controllers;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Rappi_U.models.Administrador;
import com.example.Rappi_U.models.Pedido;
import com.example.Rappi_U.service.AdministradorService;

@RestController
@RequestMapping("api/admin")
public class AdministradorController {

    @Autowired
    private AdministradorService administradorService;

    @PostMapping
    public Administrador createAdministrador(@RequestBody Map<String, String> adminData) {
        try {
            String nombre = adminData.get("nombre");
            String email = adminData.get("email");
            String password = adminData.get("password");

            if (nombre == null || email == null || password == null) {
                throw new IllegalArgumentException("Datos incompletos para crear administrador.");
            }

            Administrador administrador = new Administrador(nombre, email, password);
            return administradorService.createAdministrador(administrador);
        } catch (IllegalArgumentException e) {
            throw new RuntimeException("Error en la creación del administrador: " + e.getMessage());
        } catch (Exception e) {
            throw new RuntimeException("Error inesperado al crear administrador: " + e.getMessage());
        }
    }

    @PostMapping("/gestionarPedido")
    public String gestionarPedido(@RequestBody Pedido pedido) {
        try {
            if (pedido == null) {
                throw new IllegalArgumentException("Datos del pedido son nulos.");
            }
            administradorService.gestionarPedido(pedido);
            return "Pedido #" + pedido.getIdPedido() + " gestionado correctamente.";
        } catch (IllegalArgumentException e) {
            return "Error al gestionar el pedido: " + e.getMessage();
        } catch (Exception e) {
            return "Error inesperado al gestionar el pedido: " + e.getMessage();
        }
    }

    @PostMapping("/actualizarEstadoPedido")
    public String actualizarEstadoPedido(@RequestBody Map<String, Object> data) {
        try {
            int idPedido = (int) data.get("idPedido");
            String estado = (String) data.get("estado");

            Pedido pedido = administradorService.findPedidoById(idPedido);
            if (pedido != null) {
                administradorService.actualizarEstadoPedido(pedido, estado);
                return "Estado del pedido #" + idPedido + " actualizado a: " + estado;
            } else {
                throw new IllegalArgumentException("Pedido no encontrado con ID: " + idPedido);
            }
        } catch (IllegalArgumentException e) {
            return "Error al actualizar estado del pedido: " + e.getMessage();
        } catch (Exception e) {
            return "Error inesperado al actualizar estado del pedido: " + e.getMessage();
        }
    }

    @GetMapping("/pedido/{id}")
    public Pedido getPedido(@PathVariable int id) {
        try {
            Pedido pedido = administradorService.findPedidoById(id);
            if (pedido == null) {
                throw new IllegalArgumentException("Pedido no encontrado con ID: " + id);
            }
            return pedido;
        } catch (IllegalArgumentException e) {
            throw new RuntimeException("Error al buscar el pedido: " + e.getMessage());
        } catch (Exception e) {
            throw new RuntimeException("Error inesperado al buscar el pedido: " + e.getMessage());
        }
    }
}
