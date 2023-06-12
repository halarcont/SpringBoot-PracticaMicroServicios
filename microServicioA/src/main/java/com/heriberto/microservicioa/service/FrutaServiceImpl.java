package com.heriberto.microservicioa.service;

import com.heriberto.microservicioa.entity.Fruta;
import com.heriberto.microservicioa.repository.FrutaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.IncorrectResultSizeDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class FrutaServiceImpl implements IFrutaService {

    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Autowired
    private FrutaRepository frutaRepository;

    @Override
    @Transactional(readOnly = true)
    public List<Fruta> findAll() {
        return jdbcTemplate.query("select * from frutas", BeanPropertyRowMapper.newInstance(Fruta.class));
    }

    @Override
    public Fruta findById(Long id) {
        try {
            Fruta fruta = jdbcTemplate.queryForObject("select * from frutas where id =?",
                    BeanPropertyRowMapper.newInstance(Fruta.class), id);
            return fruta;
        } catch (IncorrectResultSizeDataAccessException e){
            return null;
        }
    }
}
