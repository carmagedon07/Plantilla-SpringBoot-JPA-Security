package com.api.page.Repository.Usuario;


import com.api.page.DTO.UsuarioDTO2;
import com.api.page.DTO.UsuarioDTO3;
import com.api.page.Entities.Usuarios.Persona;
import com.api.page.Entities.Usuarios.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Set;

public interface UsuarioRepository extends JpaRepository<Usuario,Integer> {

    @Modifying
    @Transactional()
    @Query(value = "INSERT INTO public.usuario(contraseña, nomnombre_usuario, configuracion_id, persona_id)VALUES " +
            "(:contraseña,:nomnombre_usuario,:configuracion_id,:persona_id);", nativeQuery = true)
    void guardarUsauario(@Param("contraseña") String contaseña, @Param("nomnombre_usuario") String nombreUsuario,
                         @Param("configuracion_id") int configuracionId, @Param("persona_id") int personaId);

    @Modifying
    @Transactional()
    @Query(value = "INSERT INTO public.usuario(uusuario_id,contraseña, nomnombre_usuario)VALUES " +
            "(:uusuario_id,:contraseña,:nomnombre_usuario);", nativeQuery = true)
    void guardarUsauarioNo(@Param("uusuario_id") int uusuarioId, @Param("contraseña") String contaseña,
                           @Param("nomnombre_usuario") String nombreUsuario);

    @Query(value = "SELECT contraseña FROM public.usuario \n" +
            "WHERE uusuario_id = :name ", nativeQuery = true)
    String contraseñaPorId(@Param("name") int name);
    /*@Query(value = "INSERT INTO public.bingo_param_board (board_numbers) "
            + "VALUES (:board_numbers);", nativeQuery = true)*/

    Usuario findByUserName(String userName);

    @Query("SELECT new com.api.page.DTO.UsuarioDTO2(u.userName,r.nombreRol) FROM Usuario u JOIN u.roles r")
    Set<UsuarioDTO2> consultaGrandeUsu();

    @Query("SELECT new com.api.page.DTO.UsuarioDTO3(r.nombreRol) FROM Usuario u JOIN u.roles r WHERE u.userName = :usena")
    Set<UsuarioDTO3> consultaRollByUser(@Param("usena") String usena);

}
