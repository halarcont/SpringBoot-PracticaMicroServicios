package com.heriberto.microservicioa.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "frutas")
public class Fruta implements Serializable {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private Double precio;

    @Column(name = "caduca_en")
    @Temporal(TemporalType.DATE)
    private Date caducaEn;

    @Transient
    private Integer port;


}
