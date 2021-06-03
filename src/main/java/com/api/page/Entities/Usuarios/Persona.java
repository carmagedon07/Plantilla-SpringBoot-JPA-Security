package com.api.page.Entities.Usuarios;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "Persona", schema = "public")
public class Persona {
    @Id
    @Column(name = "persona_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Basic
    @Column(name = "nombre")
    private String name;
    @Basic
    @Column(name = "primer_apellido")
    private String primerApellido;
    @Basic
    @Column(name = "Segundo_apellido")
    private String SegundoApellido;
    @Basic
    @Column(name = "fecha_Nacimiento")
    private String fechaNacimiento;

    @Basic
    @Column(name = "configuracion_id")
    private int idConfiguracion;

    public Persona(){}

    public Persona(int id, String name, String primerApellido, String segundoApellido, String fechaNacimiento,
                   int idConfiguracion) {
        this.id = id;
        this.name = name;
        this.primerApellido = primerApellido;
        SegundoApellido = segundoApellido;
        this.fechaNacimiento = fechaNacimiento;
        this.idConfiguracion = idConfiguracion;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public int getIdConfiguracion() {
        return idConfiguracion;
    }

    public void setIdConfiguracion(int idConfiguracion) {
        this.idConfiguracion = idConfiguracion;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Persona persona = (Persona) o;
        return id == persona.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Persona{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", primerApellido='" + primerApellido + '\'' +
                ", SegundoApellido='" + SegundoApellido + '\'' +
                ", fechaNacimiento='" + fechaNacimiento + '\'' +
                ", idConfiguracion=" + idConfiguracion +
                '}';
    }
}
