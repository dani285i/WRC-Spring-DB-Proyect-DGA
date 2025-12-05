package edu.dani.back.wrc.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import edu.dani.back.wrc.model.enums.Clima;
import edu.dani.back.wrc.model.enums.TipoSuperficie;
import edu.dani.back.wrc.model.vo.CoordenadasGPS;
import jakarta.persistence.Embedded;
import jakarta.persistence.AttributeOverride;
import jakarta.persistence.AttributeOverrides;
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
@Table(name = "tramo")
public class Tramo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_tramo;

    @Column(name = "nombre_tramo", nullable = false, length = 55)
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

    // Rally manda sobre tramo
    @ManyToOne
    @JoinColumn(name = "id_rally", nullable = false)
    private Rally rally;

    // Tramo manda sobre inscripcion
    @OneToMany(mappedBy = "tramo", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Inscripcion> inscripcion = new ArrayList<>();

    @Embedded
    @AttributeOverrides({
        @AttributeOverride(name = "latitud", column = @Column(name = "latitud", nullable = false, scale = 2)),
        @AttributeOverride(name = "longitud", column = @Column(name = "longitud", nullable = false, scale = 2)),
        @AttributeOverride(name = "altitudSobreElMar", column = @Column(name = "altitud_sobre_el_mar", nullable = false))
    })
    private CoordenadasGPS localizacion;

    public Tramo() {
    }

    public Tramo(String nombre, double distancia, BigDecimal horaDia, Clima clima, TipoSuperficie tipoSuperficie) {
        this.nombre = nombre;
        this.distancia = distancia;
        this.horaDia = horaDia;
        this.clima = clima;
        this.tipoSuperficie = tipoSuperficie;
    }

    public Long getId_tramo() {
        return id_tramo;
    }

    public void setId_tramo(Long id_tramo) {
        this.id_tramo = id_tramo;
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

    public CoordenadasGPS getLocalizacion() {
        return localizacion;
    }

    public void setLocalizacion(CoordenadasGPS localizacion) {
        this.localizacion = localizacion;
    }

    @Override
    public String toString() {
        return "Etapa [id=" + id_tramo + ", nombre=" + nombre + ", distancia=" + distancia + "]";
    }
}