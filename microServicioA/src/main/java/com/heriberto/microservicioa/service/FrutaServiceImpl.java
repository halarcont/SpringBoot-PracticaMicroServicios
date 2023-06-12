package com.heriberto.microservicioa.service;

import com.heriberto.microservicioa.entity.Fruta;
import com.heriberto.microservicioa.repository.FrutaRepository;
import lombok.RequiredArgsConstructor;
import org.aspectj.lang.annotation.RequiredTypes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.IncorrectResultSizeDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FrutaServiceImpl implements IFrutaService {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private IFrutaService iFrutaService;


    private final FrutaRepository frutaRepository;

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

    @Override
    public int deleteById(long id) {
        return jdbcTemplate.update("delete from frutas where id=?", id);
    }

    @Override
    @Transactional
    public Fruta save(Fruta fruta) {
        return frutaRepository.save(fruta);
    }

    /*@Override
    @Transactional
    public boolean insert(Fruta fruta) {
        String sql = "INSERT INTO frutas (nombre, color, peso) VALUES (?, ?, ?)";
        boolean success = false;

        try (Connection conn = DriverManager.getConnection("localhost:5432/frutasDB", "postgres", "postgres");
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, fruta.getNombre());
            stmt.setDouble(2, fruta.getPrecio());
            stmt.setDate(3, (Date) fruta.getCaducaEn());
            int rowsAffected = stmt.executeUpdate();
            success = rowsAffected > 0;
        } catch (SQLException e) {
            return Boolean.parseBoolean(null);
        }

        return success;
    }*/

}
