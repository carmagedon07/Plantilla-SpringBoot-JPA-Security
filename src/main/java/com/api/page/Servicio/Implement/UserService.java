package com.api.page.Servicio.Implement;

import com.api.page.DTO.UsuarioDTO3;
import com.api.page.Entities.Usuarios.Usuario;
import com.api.page.Repository.Usuario.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Service
public class UserService implements UserDetailsService {
    @Autowired
    private UsuarioRepository usuarioRepo;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        Usuario us = usuarioRepo.findByUserName(username);



        List<GrantedAuthority> roles = new ArrayList<>();

        Set<UsuarioDTO3> userRol = usuarioRepo.consultaRollByUser(username);

        for (UsuarioDTO3 rol:userRol ) {

            String strRol =rol.getNombreRol();

            roles.add(new SimpleGrantedAuthority(strRol));
        }

        //roles.add(new SimpleGrantedAuthority("Admin"));

        UserDetails userDet = new User(us.getUserName(),us.getPassword(),roles);

        return userDet;
    }
}
