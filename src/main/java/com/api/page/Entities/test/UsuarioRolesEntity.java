package com.api.page.Entities.test;

import javax.persistence.*;

@Entity
@Table(name = "usuario_roles", schema = "public", catalog = "base_test")
@IdClass(UsuarioRolesEntityPK.class)
public class UsuarioRolesEntity {
    private int uusuarioId;
    private int rolId;

    @Id
    @Column(name = "uusuario_id")
    public int getUusuarioId() {
        return uusuarioId;
    }

    public void setUusuarioId(int uusuarioId) {
        this.uusuarioId = uusuarioId;
    }

    @Id
    @Column(name = "rol_id")
    public int getRolId() {
        return rolId;
    }

    public void setRolId(int rolId) {
        this.rolId = rolId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UsuarioRolesEntity that = (UsuarioRolesEntity) o;

        if (uusuarioId != that.uusuarioId) return false;
        if (rolId != that.rolId) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = uusuarioId;
        result = 31 * result + rolId;
        return result;
    }
}
