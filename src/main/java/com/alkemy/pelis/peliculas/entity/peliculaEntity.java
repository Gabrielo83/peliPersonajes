package com.alkemy.pelis.peliculas.entity;

import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;


@Entity
@Table(name="pelicula")
@Getter
@Setter
public class peliculaEntity {

    @Id
    @Column(name = "idpelicula")
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    private String imagen;

    private String titulo;

    @Column(name = "fecha_creacion")
    @DateTimeFormat(pattern = "yyyy/mm/dd")
    private LocalDate fechaCreacion;

    private int calificacion;

    //Cardinalidad con tabla GENERO (UNO A UNO)
    @OneToOne(mappedBy = "pelicula", cascade = CascadeType.ALL)
    private generoEntity genero;

    //Cardinalidad con tabla PERSONAJE (MUCHOS A MUCHOS)
    //Se crea una pelicula, se pasa la lista de personajes y se va a crear la relación
    @ManyToMany(
            cascade = {
                    CascadeType.PERSIST,
                    CascadeType.MERGE
            })

    //Join a la Tabla intermedia "peli_pers"
    @JoinTable(
            name = "peli_pers",
            joinColumns = @JoinColumn(name = "fk_pelicula"),
            inverseJoinColumns = @JoinColumn(name = "fk_personaje")
    )
    private Set<personajeEntity> personaje = new HashSet<>();

    @Override
    public boolean equals(Object obj){
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        final peliculaEntity other = (peliculaEntity) obj;
        return other.id == this.id;
    }


}
