package com.heriberto.microservicioa.service;

import com.heriberto.microservicioa.entity.Fruta;

import java.util.List;

public interface IFrutaService {

    public List<Fruta> findAll();

    public Fruta findById(Long id);

    public int deleteById(long id);

    public Fruta save(Fruta fruta);

}

