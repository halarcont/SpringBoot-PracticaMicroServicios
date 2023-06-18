package com.heriberto.oauth.serviciooatuh.clients;

import com.heriberto.usuariocommons.entity.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name="servicio-usuarios")
public interface UsuarioFeignClient {

    @GetMapping("/usuarios/search/buscar-username")
    public User findByUsername(@RequestParam String username);
}
