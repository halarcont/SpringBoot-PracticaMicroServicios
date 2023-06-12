package com.heriberto.microservicioa.controllers;

import com.heriberto.microservicioa.entity.Fruta;
import com.heriberto.microservicioa.repository.FrutaRepository;
import com.heriberto.microservicioa.service.IFrutaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.sql.*;
import java.util.List;
import java.util.stream.Collectors;

import static org.bouncycastle.cms.RecipientId.password;

@RestController
public class FrutaController {

    @Value("${server.port}")
    private Integer port;

    @Autowired
    private IFrutaService frutaService;

    @Autowired
    private FrutaRepository frutaRepository;

    @GetMapping("/listar")
    public List<Fruta> listar (){
        return frutaService.findAll().stream().map(fruta -> {
            fruta.setPort(port);
            return fruta;
        }).collect(Collectors.toList());
    }

    /*@GetMapping("/detalle/{id}")
    public Fruta detalle(@PathVariable Long id){
        Fruta fruta = frutaService.findById(id);
        fruta.setPort(port);
        return frutaService.findById(id);
    }*/
    @GetMapping("/detalle/{id}")
    public ResponseEntity<Fruta> getTutorialById(@PathVariable("id") long id) {
        Fruta fruta = frutaRepository.findById(id).orElse(null);

        if (fruta != null) {
            return new ResponseEntity<>(fruta, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(fruta, HttpStatus.NOT_FOUND);
        }
    }
}
