package edu.dani.back.wrc.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

import java.util.ArrayList; // Importante para inicializar la lista
import java.util.List;

@Entity
@Table(name = "patrocinador")
public class PatrocinadorOficial {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_patrocinador;

    @Column(name="nombre_patrocinador", nullable = true, length = 100)
    private String nombre; 

    @Column(name = "sector_industria", nullable = true, length = 100)
    private String sectorIndustria;

    @Column(name = "pagina_web", nullable = true, length = 255)
    private String paginaWeb;

    // Patrocinador manda sobre coche 
    @OneToMany(mappedBy = "patrocinador", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Coche> coches = new ArrayList<>(); 

    public PatrocinadorOficial() {
    }

    public PatrocinadorOficial(String nombre, String sectorIndustria, String paginaWeb) {
        this.nombre = nombre;
        this.sectorIndustria = sectorIndustria;
        this.paginaWeb = paginaWeb;
    }

    public PatrocinadorOficial(Long id, String nombre, String sectorIndustria, String paginaWeb) {
        this.id_patrocinador = id;
        this.nombre = nombre;
        this.sectorIndustria = sectorIndustria;
        this.paginaWeb = paginaWeb;
    }

    public Long getId_patrocinador() {
        return id_patrocinador;
    }

    public void setId_patrocinador(Long id_patrocinador) {
        this.id_patrocinador = id_patrocinador;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getSectorIndustria() {
        return sectorIndustria;
    }

    public void setSectorIndustria(String sectorIndustria) {
        this.sectorIndustria = sectorIndustria;
    }

    public String getPaginaWeb() {
        return paginaWeb;
    }

    public void setPaginaWeb(String paginaWeb) {
        this.paginaWeb = paginaWeb;
    }

    public List<Coche> getCoches() {
        return coches;
    }

    public void setCoches(List<Coche> coches) {
        this.coches = coches;
    }
}