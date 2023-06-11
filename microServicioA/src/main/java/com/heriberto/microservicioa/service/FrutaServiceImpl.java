package com.heriberto.microservicioa.service;

import com.heriberto.microservicioa.entity.Fruta;
import com.heriberto.microservicioa.repository.FrutaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class FrutaServiceImpl implements IFrutaService {


    @Autowired
    private FrutaRepository frutaRepository;

    @Override
    @Transactional(readOnly = true)
    public List<Fruta> findAll() {
        return (List<Fruta>) frutaRepository.findAll();
    }

    @Override
    public Fruta findById(Long id) {
        return frutaRepository.findById(id).orElse(null) ;
    }
}
