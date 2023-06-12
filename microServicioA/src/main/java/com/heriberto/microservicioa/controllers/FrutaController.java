package com.heriberto.microservicioa.controllers;

import com.heriberto.microservicioa.entity.Fruta;
import com.heriberto.microservicioa.repository.FrutaRepository;
import com.heriberto.microservicioa.service.IFrutaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.sql.*;
import java.util.ArrayList;
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
    public ResponseEntity<Fruta> getFrutasById(@PathVariable("id") long id) {
        Fruta fruta = frutaService.findById(id);

        if (fruta != null) {
            return new ResponseEntity<>(fruta, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(fruta, HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/frutas/{id}")
    public ResponseEntity<String> deleteFrutas(@PathVariable("id")long id){
        try{
            int result = frutaService.deleteById(id);
            if (result == 0) {
                return new ResponseEntity<>("no se puede encontrar la fruta con el id=" + id, HttpStatus.NOT_FOUND);
            }
            return new ResponseEntity<>("la fruta fue eliminada", HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>("no se pudo eliminar la fruta.", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/insertFruta")
    @ResponseStatus(HttpStatus.CREATED)
    public Fruta crear(@RequestBody Fruta fruta){
        return frutaService.save(fruta);
    }

    /*@PostMapping("/insertFruta")
    public String insert(@ModelAttribute("fruta") Fruta fruta, Model model) {
        boolean success = frutaService.insert(fruta);
        model.addAttribute("success", success);
        return "success";
    }*/

}

