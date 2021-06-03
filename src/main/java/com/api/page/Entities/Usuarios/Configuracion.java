package com.api.page.Entities.Usuarios;


import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "Configuracion", schema = "public")
public class Configuracion {

    @Id
    @Column(name = "configuracion_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Basic
    @Column(name = "idioma")
    private String idioma;
    @Basic
    @Column(name = "pais")
    private String pais;

    @Basic
    @Column(name = "estado")
    private boolean activo;

    public Configuracion(){}

    public Configuracion(int id, String idioma, String pais, boolean activo) {
        this.id = id;
        this.idioma = idioma;
        this.pais = pais;
        this.activo = activo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getIdioma() {
        return idioma;
    }

    public void setIdioma(String idioma) {
        this.idioma = idioma;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Configuracion that = (Configuracion) o;
        return id == that.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Configuracion{" +
                "id=" + id +
                ", idioma='" + idioma + '\'' +
                ", pais='" + pais + '\'' +
                ", activo=" + activo +
                '}';
    }
}
