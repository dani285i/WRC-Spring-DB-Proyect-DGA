package edu.dani.back.wrc.model;

import java.util.ArrayList;
import java.util.List;

import edu.dani.back.wrc.model.enums.Categoria; // Asegúrate de importar tu Enum
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
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

    @Enumerated(EnumType.STRING)
    @Column(name = "categoria", nullable = false) 
    private Categoria categoria;
    
    // Relación con Coche
    @OneToMany(mappedBy = "equipo", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Coche> coche = new ArrayList<>();

    @ManyToOne
    @JoinColumn(name="id_rally", nullable = true)
    private Rally rally;

    public Equipo() {
    }

    public Equipo(String nombre, String director, String paisOrigen, Categoria categoria) {
        this.nombre = nombre;
        this.director = director;
        this.paisOrigen = paisOrigen;
        this.categoria = categoria;
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

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public List<Coche> getCoche() {
        return coche;
    }

    public void setCoche(List<Coche> coche) {
        this.coche = coche;
    }

    public Rally getRally() {
        return rally;
    }

    public void setRally(Rally rally) {
        this.rally = rally;
    }

    @Override
    public String toString() {
        return "Equipo [id_equipo=" + id_equipo + ", nombre=" + nombre + ", director=" + director + ", paisOrigen="
                + paisOrigen + "]";
    }
    
}
