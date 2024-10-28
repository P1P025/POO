package com.example.Rappi_U.models;
public class Usuario {
    private String nombre;
    private String email;
    private String password;
    private String rol;

    public Usuario(String nombre, String email, String password, String rol) {
        this.nombre = nombre;
        this.email = email;
        this.password = password;
        this.rol = rol;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    public void registrarse() {
        System.out.println("Usuario registrado: " + nombre);
    }

    public void iniciarSesion() {
        System.out.println("Usuario inició sesión: " + nombre);
    }

    public void verHistorialPedidos() {
        System.out.println("Mostrando historial de pedidos.");
    }
}
