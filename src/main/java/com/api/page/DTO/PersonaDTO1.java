package com.api.page.DTO;

public class PersonaDTO1 {

    private String name;
    private String primerApellido;
    private String SegundoApellido;
    private String fechaNacimiento;

    public PersonaDTO1(){}

    public PersonaDTO1(String name, String primerApellido, String segundoApellido, String fechaNacimiento) {
        this.name = name;
        this.primerApellido = primerApellido;
        SegundoApellido = segundoApellido;
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrimerApellido() {
        return primerApellido;
    }

    public void setPrimerApellido(String primerApellido) {
        this.primerApellido = primerApellido;
    }

    public String getSegundoApellido() {
        return SegundoApellido;
    }

    public void setSegundoApellido(String segundoApellido) {
        SegundoApellido = segundoApellido;
    }

    public String getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(String fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }
}
