package com.heriberto.microserviciob.service;

import com.heriberto.microserviciob.models.Registro;

import java.util.List;

public interface RegistroServiceFeign {
    public List<Registro> findAll();
    public Registro findById(Long id, Integer Cantidad);
}
