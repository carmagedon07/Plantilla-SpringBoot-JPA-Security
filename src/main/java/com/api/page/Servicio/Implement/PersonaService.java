package com.api.page.Servicio.Implement;


import com.api.page.DTO.PersonaDTO1;
import com.api.page.Entities.Usuarios.Persona;
import com.api.page.Repository.Usuario.ConfiguracionRepository;
import com.api.page.Repository.Usuario.PersonaRepository;
import com.api.page.Servicio.interfaces.IPersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonaService  implements IPersonaService {

    @Autowired
    PersonaRepository personaRepository;

    @Autowired
    ConfiguracionRepository configuracionRepository;

    @Override
    public void insertarPersona(Persona pe) {

        pe.setId(1);
        pe.setIdConfiguracion(1);

        personaRepository.save(pe);


    }

    @Override
    public void insertarPersonaDTO1(PersonaDTO1 pe) {

         String name;
         String primerApellido;
         String SegundoApellido;
         String fechaNacimiento;
         int configuracion_id;

        Persona per = new Persona();

        name =pe.getName();
        primerApellido= pe.getPrimerApellido();
        SegundoApellido = pe.getSegundoApellido();
        fechaNacimiento = pe.getFechaNacimiento();

        per.setPrimerApellido(name);
        per.setPrimerApellido(primerApellido);
        per.setSegundoApellido(SegundoApellido);
        per.setFechaNacimiento(fechaNacimiento);
        configuracion_id = personaRepository.valorID() + 1;

        per.setIdConfiguracion(configuracion_id);
        personaRepository.save(per);


    }
}
