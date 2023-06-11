package com.heriberto.microserviciob.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Fruta {

    private Long id;
    private String nombre;
    private Double precio;
    private Date caducaEn;
    private Integer port;
}
