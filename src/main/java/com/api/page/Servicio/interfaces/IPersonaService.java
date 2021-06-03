package com.api.page.Servicio.interfaces;


import com.api.page.DTO.PersonaDTO1;
import com.api.page.Entities.Usuarios.Persona;

public interface IPersonaService {

    public void insertarPersona(Persona pe);

    public void insertarPersonaDTO1(PersonaDTO1 pe);
}
