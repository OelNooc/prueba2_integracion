package com.prueba2.model;

public class Usuario {
    private String rut;
    private String username;
    private String password;

    public Usuario(String rut, String username, String password) {
        this.rut = rut;
        this.username = username;
        this.password = password;
    }

    public String getRut() {
        return rut;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public void setRut(String rut) {
        this.rut = rut;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}