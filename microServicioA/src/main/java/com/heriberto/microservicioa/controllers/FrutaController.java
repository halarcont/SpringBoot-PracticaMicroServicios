package com.heriberto.microservicioa.controllers;

import com.heriberto.microservicioa.entity.Fruta;
import com.heriberto.microservicioa.service.IFrutaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class FrutaController {

    @Value("${server.port}")
    private Integer port;

    @Autowired
    private IFrutaService frutaService;

    @GetMapping("/listar")
    public List<Fruta> listar (){
        return frutaService.findAll().stream().map(fruta -> {
            fruta.setPort(port);
            return fruta;
        }).collect(Collectors.toList());
    }

    @GetMapping("/detalle/{id}")
    public Fruta detalle(@PathVariable Long id){
        Fruta fruta = frutaService.findById(id);
        fruta.setPort(port);
        return frutaService.findById(id);
    }
}
