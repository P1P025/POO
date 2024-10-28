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
        String nombre = adminData.get("nombre");
        String email = adminData.get("email");
        String password = adminData.get("password");

        Administrador administrador = new Administrador(nombre, email, password);
        return administradorService.createAdministrador(administrador);
    }

    @PostMapping("/gestionarPedido")
    public String gestionarPedido(@RequestBody Pedido pedido) {
        administradorService.gestionarPedido(pedido);
        return "Pedido #" + pedido.getIdPedido() + " gestionado correctamente.";
    }

    @PostMapping("/actualizarEstadoPedido")
    public String actualizarEstadoPedido(@RequestBody Map<String, Object> data) {
        int idPedido = (int) data.get("idPedido");
        String estado = (String) data.get("estado");

        Pedido pedido = administradorService.findPedidoById(idPedido);
        if (pedido != null) {
            administradorService.actualizarEstadoPedido(pedido, estado);
            return "Estado del pedido #" + idPedido + " actualizado a: " + estado;
        } else {
            throw new IllegalArgumentException("Pedido no encontrado con ID: " + idPedido);
        }
    }

    @GetMapping("/pedido/{id}")
    public Pedido getPedido(@PathVariable int id) {
        return administradorService.findPedidoById(id);
    }

}
