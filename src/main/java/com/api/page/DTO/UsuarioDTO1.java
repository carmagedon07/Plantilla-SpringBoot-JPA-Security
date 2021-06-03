package com.api.page.DTO;

public class UsuarioDTO1 {

    private String username;
    private String password;
    private int idconfiguracion;
    private int idPersona;

    public UsuarioDTO1(){}

    public UsuarioDTO1(String username, String password, int idconfiguracion, int idPersona) {
        this.username = username;
        this.password = password;
        this.idconfiguracion = idconfiguracion;
        this.idPersona = idPersona;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getIdconfiguracion() {
        return idconfiguracion;
    }

    public void setIdconfiguracion(int idconfiguracion) {
        this.idconfiguracion = idconfiguracion;
    }

    public int getIdPersona() {
        return idPersona;
    }

    public void setIdPersona(int idPersona) {
        this.idPersona = idPersona;
    }
}
