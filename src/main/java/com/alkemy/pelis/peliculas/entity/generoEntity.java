package com.alkemy.pelis.peliculas.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;


@Entity
@Table(name = "genero")
@Getter
@Setter
public class generoEntity {

    @Id
    @Column(name = "idgenero")
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    private String nombre;

    private String imagen;

    @OneToOne
    @JoinColumn(name =  "fk_pelicula", updatable = false, nullable = false)
    private peliculaEntity pelicula;
}
