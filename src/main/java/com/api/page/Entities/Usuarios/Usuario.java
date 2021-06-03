package com.api.page.Entities.Usuarios;


import javax.persistence.*;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "Usuario", schema = "public")
public class Usuario {
    @Id
    @Column(name = "Uusuario_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Basic
    @Column(name = "nomnombre_usuario")
    private String userName;
    @Basic
    @Column(name = "contraseña")
    private String password;

    @ManyToMany
    @JoinTable(name="usuario_roles",
        joinColumns = @JoinColumn(name="Uusuario_id"),
            inverseJoinColumns = @JoinColumn(name="rol_id")
    )
    private Set<Rol>roles;

    @JoinColumn(name="configuracion_id")
    @OneToOne(cascade = CascadeType.ALL)
    private Configuracion configuracion;
    @JoinColumn(name="persona_id")
    @OneToOne(cascade = CascadeType.ALL)
    private Persona persona;

    public Usuario() {
    }

    public Usuario(String userName, String password,
                   Set<Rol> roles, Configuracion configuracion, Persona persona) {
        this.userName = userName;
        this.password = password;
        this.roles = roles;
        this.configuracion = configuracion;
        this.persona = persona;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String username) {
        this.userName = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Set<Rol> getRoles() {
        return roles;
    }

    public void setRoles(Set<Rol> roles) {
        this.roles = roles;
    }

    public Configuracion getConfiguracion() {
        return configuracion;
    }

    public void setConfiguracion(Configuracion configuracion) {
        this.configuracion = configuracion;
    }

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Usuario usuario = (Usuario) o;
        return id == usuario.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "id=" + id +
                ", username='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", roles=" + roles +
                ", configuracion=" + configuracion +
                ", persona=" + persona +
                '}';
    }
}
