package com.alkemy.pelis.peliculas.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.security.PrivateKey;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "personaje")
@Getter
@Setter
public class personajeEntity {

    @Id
    @Column(name = "idpersonaje")
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    private String imagen;

    private String nombre;

    private int edad;

    private Double peso;

    private String historia;

    //Cardinalidad con tabla PELICULA (MUCHOS A MUCHOS)
    //Se crea un personaje y no le pasa una lista de personajes para que se cree la relación
    @ManyToMany(mappedBy = "personaje", cascade = CascadeType.ALL)
    private List<peliculaEntity> pelicula = new ArrayList<>();

    //Agregar y Remover peliculas
    public void addPeliculas(peliculaEntity pelicula){
        this.pelicula.add(pelicula);
    }
    public void removePeliculas(peliculaEntity pelicula){
        this.pelicula.add(pelicula);
    }
}
