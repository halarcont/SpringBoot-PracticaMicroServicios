package com.heriberto.microservicioa.repository;

import com.heriberto.microservicioa.entity.Fruta;
import org.springframework.data.jpa.repository.JpaRepository;


public interface FrutaRepository extends JpaRepository<Fruta, Long> {

}

