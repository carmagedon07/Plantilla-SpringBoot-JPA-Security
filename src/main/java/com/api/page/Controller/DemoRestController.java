package com.api.page.Controller;


import com.api.page.DTO.PersonaDTO1;
import com.api.page.DTO.UsuarioDTO2;
import com.api.page.DTO.UsuarioDTO3;
import com.api.page.Entities.Usuarios.Persona;
import com.api.page.Entities.Usuarios.Usuario;
import com.api.page.Repository.Usuario.PersonaRepository;
import com.api.page.Repository.Usuario.UsuarioRepository;
import com.api.page.Servicio.Implement.PersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/test")
public class DemoRestController {

    @Autowired
    private PersonaRepository personaRepository;

    @Autowired
    private PersonaService personaService;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @GetMapping("/1")
    public List<Persona> cons(){

        Persona per = new Persona();


        per.setName("pedro");
        per.setPrimerApellido("Caro");
        per.setFechaNacimiento("7 de abril");

        personaRepository.save(per);

        return personaRepository.findAll();
    }

    @GetMapping("/3")
    String valor(){
        return usuarioRepository.contraseñaPorId(1);
    }

    /*@PostMapping(path = "/2",consumes ={MediaType.APPLICATION_JSON_VALUE},
            produces ={MediaType.APPLICATION_JSON_VALUE}))*/
    @PostMapping(path="/2",consumes ={MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<PersonaDTO1> instPersona(@RequestBody PersonaDTO1 personaDTO1)
    {
        personaService.insertarPersonaDTO1(personaDTO1);

        return new ResponseEntity <PersonaDTO1>(personaDTO1,HttpStatus.OK);
    }

    @GetMapping("/4")
    public Set<UsuarioDTO2> consultaPersona(){
        return usuarioRepository.consultaGrandeUsu();
    }

    @GetMapping("/5")
    public Set<UsuarioDTO3> consultaRolByUsername(){
        return usuarioRepository.consultaRollByUser("manteca2");
    }
}
