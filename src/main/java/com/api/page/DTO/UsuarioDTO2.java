package com.api.page.DTO;

import com.api.page.Entities.Usuarios.Rol;

import java.util.Set;

public class UsuarioDTO2 {
    private String userName;

    private String nombreRol;

    public UsuarioDTO2(String userName, String nombreRol) {
        this.userName = userName;
        this.nombreRol = nombreRol;
    }

    public UsuarioDTO2(String userName) {
        this.userName = userName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getNombreRol() {
        return nombreRol;
    }

    public void setNombreRol(String nombreRol) {
        this.nombreRol = nombreRol;
    }
}
