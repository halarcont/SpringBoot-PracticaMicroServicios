package com.heriberto.microserviciob.controllers;

import com.heriberto.microserviciob.models.Registro;
import com.heriberto.microserviciob.service.RegistroServiceFeign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RefreshScope
public class RegistroController {

    @Autowired
    private RegistroServiceFeign registroService;

    @GetMapping("/listar")
    public List<Registro> listar(){
        return registroService.findAll();
    }

    @GetMapping("/ver/{id}/cantidad/{cantidad}")
    public Registro detalle(@PathVariable Long id, @PathVariable Integer cantidad){
        return registroService.findById(id, cantidad);
    }

}

