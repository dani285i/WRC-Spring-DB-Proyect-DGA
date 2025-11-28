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
public class Patrocinador {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_patrocinador;

    @Column(name="nombre", nullable = false, length = 100)
    private String nombre; 

    @Column(name = "sector_Industria", nullable = false, length = 100)
    private String sectorIndustria;

    @Column(name = "pagina_web", nullable = true, length = 255)
    private String paginaWeb;

    //mappedBy apunta a "patrocinador" en la clase Coche
    @OneToMany(mappedBy = "patrocinador", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Coche> coches = new ArrayList<>(); 

    public Patrocinador() {
    }

    public Patrocinador(String nombre, String sectorIndustria, String paginaWeb) {
        this.nombre = nombre;
        this.sectorIndustria = sectorIndustria;
        this.paginaWeb = paginaWeb;
    }

    public Patrocinador(Long id, String nombre, String sectorIndustria, String paginaWeb) {
        this.id_patrocinador = id;
        this.nombre = nombre;
        this.sectorIndustria = sectorIndustria;
        this.paginaWeb = paginaWeb;
    }

    // --- GETTERS Y SETTERS ---

    public Long getId_patrocinador() {
        return id_patrocinador;
    }

    public void setId_patrocinador(Long id) {
        this.id_patrocinador = id;
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

    // CORRECCIÓN 2: Los métodos ahora coinciden con la variable 'coches'
    public List<Coche> getCoches() {
        return coches;
    }

    public void setCoches(List<Coche> coches) {
        this.coches = coches;
    }
}