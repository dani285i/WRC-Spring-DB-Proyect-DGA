package edu.dani.back.wrc.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import edu.dani.back.wrc.model.vo.Dni;
import edu.dani.back.wrc.model.vo.LicenciaFia;
import jakarta.persistence.AttributeOverride;
import jakarta.persistence.AttributeOverrides;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
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

    @Column(name="apellido", nullable = false, length = 100)
    private String apellidos;

    @Column(name="nacionalidad", nullable = false, length = 55)
    private String nacionalidad;

    @Column(name="fecha_nacimiento", nullable = false)
    private LocalDate fechaNacimiento;

    @Embedded
    @AttributeOverrides({
        @AttributeOverride(name = "numeroDni", column = @Column(name = "numeroDni", nullable = false)),
        @AttributeOverride(name = "letraDni", column = @Column(name = "letraDni", nullable = false))
    })
    private Dni dni;

    @Embedded
    @AttributeOverrides({
        @AttributeOverride(name = "numeroLicencia", column = @Column(name = "numeroLicencia", nullable = false)),
        @AttributeOverride(name = "fechaCaducidad", column = @Column(name = "fechaCaducidad", nullable = false)),
        @AttributeOverride(name = "grupoSanguineo", column = @Column(name = "grupoSanguineo", nullable = false))
    })
    private LicenciaFia licenciafia;

    // Piloto manda sobre inscripcion
    @OneToMany(mappedBy = "piloto", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Inscripcion> inscripciones = new ArrayList<>();

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

    public Dni getDni() {
        return dni;
    }

    public void setDni(Dni dni) {
        this.dni = dni;
    }

    public LicenciaFia getLicenciafia() {
        return licenciafia;
    }

    public void setLicenciafia(LicenciaFia licenciafia) {
        this.licenciafia = licenciafia;
    }

    public List<Inscripcion> getInscripciones() {
        return inscripciones;
    }

    public void setInscripciones(List<Inscripcion> inscripciones) {
        this.inscripciones = inscripciones;
    }

    @Override
    public String toString() {
        return "Piloto [id=" + id_piloto + ", nombre=" + nombre + ", apellidos=" + apellidos + "]";
    }
}