package com.api.page.Repository.Usuario;


import com.api.page.Entities.Usuarios.Persona;
import org.hibernate.mapping.Value;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


public interface PersonaRepository extends JpaRepository<Persona,Integer> {

    @Query(value = "SELECT configuracion_id FROM public.persona\n" +
            "ORDER BY persona_id DESC\n" +
            "offset 0 limit 1 ;",nativeQuery = true)
    public int valorID ();
}
