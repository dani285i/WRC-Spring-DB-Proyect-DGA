package edu.dani.back.wrc.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "equipo")
public class Equipo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_equipo;

    @Column(name="nombre", nullable = false)
    private String nombre;

    @Column(name="director", nullable = false)
    private String director;
    
    @Column(name="pais_origen", nullable = false)
    private String paisOrigen;

    public Equipo() {
    }

    public Equipo(String nombre, String director, String paisOrigen) {
        this.nombre = nombre;
        this.director = director;
        this.paisOrigen = paisOrigen;
    }

    public Equipo(Long id_equipo, String nombre, String director, String paisOrigen) {
        this.id_equipo = id_equipo;
        this.nombre = nombre;
        this.director = director;
        this.paisOrigen = paisOrigen;
    }

    public Long getId_equipo() {
        return id_equipo;
    }

    public void setId_equipo(Long id_equipo) {
        this.id_equipo = id_equipo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getPaisOrigen() {
        return paisOrigen;
    }

    public void setPaisOrigen(String paisOrigen) {
        this.paisOrigen = paisOrigen;
    }

    @Override
    public String toString() {
        return "Equipo [id_equipo=" + id_equipo + ", nombre=" + nombre + ", director=" + director + ", paisOrigen="
                + paisOrigen + "]";
    }
    
}
