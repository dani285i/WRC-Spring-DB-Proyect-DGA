package edu.dani.back.wrc.model;

import java.math.BigDecimal;

import edu.dani.back.wrc.model.enums.Clima;
import edu.dani.back.wrc.model.enums.TipoSuperficie;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "etapas")
public class Etapas {

@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long id_etapa;

@Column(name = "nombre", nullable = false, length = 55)
private String nombre;

@Column(name = "distancia", nullable = false, length = 55)
private double distancia;

@Column(name = "hora", nullable = false, length = 55)
private BigDecimal horaDia;

@Enumerated(EnumType.STRING)
@Column(name = "clima", nullable = false)
private Clima clima;

@Enumerated(EnumType.STRING)
@Column(name = "superficie", nullable = false)
private TipoSuperficie tipoSuperficie;

public Etapas() {
}

public Etapas(String nombre, double distancia, BigDecimal horaDia, Clima clima, TipoSuperficie tipoSuperficie) {
    this.nombre = nombre;
    this.distancia = distancia;
    this.horaDia = horaDia;
    this.clima = clima;
    this.tipoSuperficie = tipoSuperficie;
}

public Etapas(Long id, String nombre, double distancia, BigDecimal horaDia, Clima clima,
        TipoSuperficie tipoSuperficie) {
    this.id_etapa = id;
    this.nombre = nombre;
    this.distancia = distancia;
    this.horaDia = horaDia;
    this.clima = clima;
    this.tipoSuperficie = tipoSuperficie;
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
    return "Etapas [id=" + id_etapa + ", nombre=" + nombre + ", distancia=" + distancia + ", horaDia=" + horaDia + ", clima="
            + clima + ", tipoSuperficie=" + tipoSuperficie + "]";
}

}
