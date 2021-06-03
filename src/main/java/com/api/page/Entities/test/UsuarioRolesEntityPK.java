package com.api.page.Entities.test;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;

public class UsuarioRolesEntityPK implements Serializable {
    private int uusuarioId;
    private int rolId;

    @Column(name = "uusuario_id")
    @Id
    public int getUusuarioId() {
        return uusuarioId;
    }

    public void setUusuarioId(int uusuarioId) {
        this.uusuarioId = uusuarioId;
    }

    @Column(name = "rol_id")
    @Id
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

        UsuarioRolesEntityPK that = (UsuarioRolesEntityPK) o;

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
