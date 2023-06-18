package com.heriberto.oauth.serviciooatuh.services;

import java.util.List;
import java.util.stream.Collectors;
import com.heriberto.oauth.serviciooatuh.clients.UsuarioFeignClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserService implements IUserService, UserDetailsService{

    private Logger log = LoggerFactory.getLogger(UserService.class);

    @Autowired
    private UsuarioFeignClient client;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        com.heriberto.usuariocommons.entity.User usuario = client.findByUsername(username);

        if(usuario == null) {
            log.error("Error en el login, no existe el usuario '"+username+"' en el sistema");
            throw new UsernameNotFoundException("Error en el login, no existe el usuario '"+username+"' en el sistema");
        }

        List<GrantedAuthority> authorities = usuario.getRoles()
                .stream()
                .map(role -> new SimpleGrantedAuthority(role.getFirstname()))
                .peek(authority -> log.info("Role: " + authority.getAuthority()))
                .collect(Collectors.toList());

        log.info("Usuario autenticado: " + username);

        return new User(usuario.getUsername(), usuario.getPassword(), usuario.getEnabled(), true,
                true, true, authorities);
    }

    @Override
    public com.heriberto.usuariocommons.entity.User findByUsername(String username) {
        return client.findByUsername(username);
    }

}