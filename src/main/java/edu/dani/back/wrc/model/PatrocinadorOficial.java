package edu.dani.back.wrc.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "patrocinador")
public class PatrocinadorOficial {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_patrocinador;

    @Column(name="nombre_patrocinador", nullable = true, length = 100)
    private String nombre_patrocinador; 

    @Column(name = "sector_industria", nullable = true, length = 100)
    private String sector_industria;

    @Column(name = "pagina_web", nullable = true, length = 255)
    private String pagina_web;

    // Patrocinador manda sobre coche 
    @OneToMany(mappedBy = "patrocinador", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Coche> coches = new ArrayList<>(); 

    public PatrocinadorOficial() {
    }

    public PatrocinadorOficial(String nombre_patrocinador, String sector_industria, String pagina_web,
            List<Coche> coches) {
        this.nombre_patrocinador = nombre_patrocinador;
        this.sector_industria = sector_industria;
        this.pagina_web = pagina_web;
        this.coches = coches;
    }

    public Long getId_patrocinador() {
        return id_patrocinador;
    }

    public void setId_patrocinador(Long id_patrocinador) {
        this.id_patrocinador = id_patrocinador;
    }

    public String getNombre_patrocinador() {
        return nombre_patrocinador;
    }

    public void setNombre_patrocinador(String nombre_patrocinador) {
        this.nombre_patrocinador = nombre_patrocinador;
    }

    public String getSector_industria() {
        return sector_industria;
    }

    public void setSector_industria(String sector_industria) {
        this.sector_industria = sector_industria;
    }

    public String getPagina_web() {
        return pagina_web;
    }

    public void setPagina_web(String pagina_web) {
        this.pagina_web = pagina_web;
    }

    public List<Coche> getCoches() {
        return coches;
    }

    public void setCoches(List<Coche> coches) {
        this.coches = coches;
    }

}