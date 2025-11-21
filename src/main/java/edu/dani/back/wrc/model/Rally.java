package edu.dani.back.wrc.model;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "rally")
public class Rally {

@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long id_rally;

@Column(name="nombre", nullable = false, length = 100)
private String nombre;

@Column(name="pais", nullable = false, length = 100)
private String pais;

@Column(name="fecha_comienzo", nullable = false)
private LocalDate fechaComienzo;

@Column(name="fecha_fin", nullable = false)
private LocalDate fechaFin;

public Rally() {
}

public Rally(String nombre, String pais, LocalDate fechaComienzo, LocalDate fechaFin) {
    this.nombre = nombre;
    this.pais = pais;
    this.fechaComienzo = fechaComienzo;
    this.fechaFin = fechaFin;
}

public Rally(Long id_rally, String nombre, String pais, LocalDate fechaComienzo, LocalDate fechaFin) {
    this.id_rally = id_rally;
    this.nombre = nombre;
    this.pais = pais;
    this.fechaComienzo = fechaComienzo;
    this.fechaFin = fechaFin;
}

public Long getId_rally() {
    return id_rally;
}

public void setId_rally(Long id_rally) {
    this.id_rally = id_rally;
}

public String getNombre() {
    return nombre;
}

public void setNombre(String nombre) {
    this.nombre = nombre;
}

public String getPais() {
    return pais;
}

public void setPais(String pais) {
    this.pais = pais;
}

public LocalDate getFechaComienzo() {
    return fechaComienzo;
}

public void setFechaComienzo(LocalDate fechaComienzo) {
    this.fechaComienzo = fechaComienzo;
}

public LocalDate getFechaFin() {
    return fechaFin;
}

public void setFechaFin(LocalDate fechaFin) {
    this.fechaFin = fechaFin;
}

@Override
public String toString() {
    return "Rally [id_rally=" + id_rally + ", nombre=" + nombre + ", pais=" + pais + ", fechaComienzo=" + fechaComienzo
            + ", fechaFin=" + fechaFin + "]";
}

}
