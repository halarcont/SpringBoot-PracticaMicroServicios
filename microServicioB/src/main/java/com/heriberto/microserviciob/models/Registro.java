package com.heriberto.microserviciob.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Registro {

    private Fruta fruta;
    private Integer cantidad;


}
