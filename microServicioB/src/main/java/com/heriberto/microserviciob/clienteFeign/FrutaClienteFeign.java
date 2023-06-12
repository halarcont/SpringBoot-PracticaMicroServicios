package com.heriberto.microserviciob.clienteFeign;

import com.heriberto.microserviciob.models.Fruta;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "servicio-frutas")
public interface FrutaClienteFeign {

    @GetMapping("/listar")
    public List<Fruta> listar ();

    @GetMapping("/detalle/{id}")
    public Fruta detalle(@PathVariable Long id);

}
