package edu.dani.back.wrc.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import edu.dani.back.wrc.model.enums.Clima;
import edu.dani.back.wrc.model.enums.TipoSuperficie;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "etapas")
public class Etapa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_etapa;

    @Column(name = "nombre", nullable = false, length = 55)
    private String nombre;

    @Column(name = "distancia_km", nullable = false)
    private double distancia;

    @Column(name = "hora", nullable = false)
    private BigDecimal horaDia;

    @Enumerated(EnumType.STRING)
    @Column(name = "clima", nullable = false)
    private Clima clima;

    @Enumerated(EnumType.STRING)
    @Column(name = "superficie", nullable = false)
    private TipoSuperficie tipoSuperficie;

    //Rally manda sobre etapa
    @ManyToOne
    @JoinColumn(name = "id_rally", nullable = false)
    private Rally rally;

    //Etapa manda sobre inscripcion
    @OneToMany(mappedBy = "etapa", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Inscripcion> inscripcion = new ArrayList<>();

    public Etapa() {
    }

    public Etapa(String nombre, double distancia, BigDecimal horaDia, Clima clima, TipoSuperficie tipoSuperficie) {
        this.nombre = nombre;
        this.distancia = distancia;
        this.horaDia = horaDia;
        this.clima = clima;
        this.tipoSuperficie = tipoSuperficie;
    }
    
    public Rally getRally() {
        return rally;
    }

    public void setRally(Rally rally) {
        this.rally = rally;
    }

    public List<Inscripcion> getInscripcion() {
        return inscripcion;
    }

    public void setInscripcion(List<Inscripcion> inscripcion) {
        this.inscripcion = inscripcion;
    }

    public Long getId_etapa() {
        return id_etapa;
    }

    public void setId_etapa(Long id) {
        this.id_etapa = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getDistancia() {
        return distancia;
    }

    public void setDistancia(double distancia) {
        this.distancia = distancia;
    }

    public BigDecimal getHoraDia() {
        return horaDia;
    }

    public void setHoraDia(BigDecimal horaDia) {
        this.horaDia = horaDia;
    }

    public Clima getClima() {
        return clima;
    }

    public void setClima(Clima clima) {
        this.clima = clima;
    }

    public TipoSuperficie getTipoSuperficie() {
        return tipoSuperficie;
    }

    public void setTipoSuperficie(TipoSuperficie tipoSuperficie) {
        this.tipoSuperficie = tipoSuperficie;
    }

    @Override
    public String toString() {
        return "Etapa [id=" + id_etapa + ", nombre=" + nombre + ", distancia=" + distancia + "]";
    }
}