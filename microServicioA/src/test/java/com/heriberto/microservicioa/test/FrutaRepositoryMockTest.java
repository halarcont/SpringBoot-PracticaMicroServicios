package com.heriberto.microservicioa.test;

import com.heriberto.microservicioa.entity.Fruta;
import com.heriberto.microservicioa.repository.FrutaRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Date;
import java.util.Optional;

@DataJpaTest
public class FrutaRepositoryMockTest {

    @Autowired
    private FrutaRepository frutaRepository;

    @Test
    public void findById() {
        Fruta fruta = Fruta.builder()
                .nombre("melon")
                .precio(Double.parseDouble("8.98"))
                .caducaEn(new Date())
                .build();
        frutaRepository.save(fruta);

        Optional<Fruta> found = frutaRepository.findById(fruta.getId());

        Assertions.assertAll(
                () -> Assertions.assertTrue(found.isPresent()),
                () -> Assertions.assertEquals(fruta.getId(), found.get().getId()),
                () -> Assertions.assertEquals(fruta.getNombre(), found.get().getNombre()),
                () -> Assertions.assertEquals(fruta.getPrecio(), found.get().getPrecio()),
                () -> Assertions.assertEquals(fruta.getCaducaEn(), found.get().getCaducaEn())
        );
    }
}
