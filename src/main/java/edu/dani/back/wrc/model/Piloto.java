package edu.dani.back.wrc.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GenerationType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "piloto")
public class Piloto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_piloto;

    @Column(name="nombre", nullable = false, length = 100)
    private String nombre;

    @Column(name="apellidos", nullable = false, length = 100)
    private String apellidos;

    @Column(name="nacionalidad", nullable = false, length = 55)
    private String nacionalidad;

    @Column(name="fecha_nacimiento", nullable = false)
    private LocalDate fechaNacimiento;

    @OneToMany(mappedBy = "piloto", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Coche> coches = new ArrayList<>();

    public Piloto() {
    }

    public Piloto(String nombre, String apellidos, String nacionalidad, LocalDate fechaNacimiento) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.nacionalidad = nacionalidad;
        this.fechaNacimiento = fechaNacimiento;
    }

    public Long getId_piloto() {
        return id_piloto;
    }

    public void setId_piloto(Long id_piloto) {
        this.id_piloto = id_piloto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getNacionalidad() {
        return nacionalidad;
    }

    public void setNacionalidad(String nacionalidad) {
        this.nacionalidad = nacionalidad;
    }

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(LocalDate fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public List<Coche> getCoches() {
        return coches;
    }

    public void setCoches(List<Coche> coches) {
        this.coches = coches;
    }

    @Override
    public String toString() {
        return "Piloto [id=" + id_piloto + ", nombre=" + nombre + ", apellidos=" + apellidos + "]";
    }
}