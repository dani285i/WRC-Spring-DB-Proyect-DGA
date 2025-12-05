package edu.dani.back.wrc.model;

import edu.dani.back.wrc.model.enums.Categoria;
import edu.dani.back.wrc.model.vo.MotorInfo;
import jakarta.persistence.AttributeOverride;
import jakarta.persistence.AttributeOverrides;
import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;

@Entity
@Table(name = "coche")
public class Coche {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_coche;

    @Column(name = "modelo", nullable = false)
    private String modelo;

    @Column(name = "dorsal", nullable = false)
    private int dorsal;
    
    @Column(name = "motor", nullable = false)
    private String motor;

    @Enumerated(EnumType.STRING)
    @Column(name="categoria", nullable = false)
    private Categoria categoria;

    @ManyToOne
    @JoinColumn(name = "id_piloto", nullable = false)
    private Piloto piloto;

    //Manda equipo sobre coche
    @ManyToOne
    @JoinColumn(name = "id_equipo", nullable = false)
    private Equipo equipo;

    // Patrocinador manda sobre coche
    @ManyToOne
    @JoinColumn(name = "id_patrocinador", nullable = true)
    private PatrocinadorOficial patrocinador;

    @Embedded
    @AttributeOverrides({
        @AttributeOverride(name = "potenciaCv", column = @Column(name = "potenciaCv", nullable = false)),
        @AttributeOverride(name = "parMotorNm", column = @Column(name = "parMotorNm", nullable = false)),
        @AttributeOverride(name = "clindradaCc", column = @Column(name = "cilindradaCc", nullable = false)),
        @AttributeOverride(name = "esHibrido", column = @Column(name = "esHibrido", nullable = false))
    })
    private MotorInfo motorinfo;

    public Coche() {
    }

    public Coche(String modelo, int dorsal, String motor, Categoria categoria, Piloto piloto,
            Equipo equipo, PatrocinadorOficial patrocinador, MotorInfo motorinfo) {
        this.modelo = modelo;
        this.dorsal = dorsal;
        this.motor = motor;
        this.categoria = categoria;
        this.piloto = piloto;
        this.equipo = equipo;
        this.patrocinador = patrocinador;
        this.motorinfo = motorinfo;
    }

    public Coche(Long id_coche, String modelo, int dorsal, String motor, Categoria categoria, Piloto piloto,
            Equipo equipo, PatrocinadorOficial patrocinador, MotorInfo motorinfo) {
        this.id_coche = id_coche;
        this.modelo = modelo;
        this.dorsal = dorsal;
        this.motor = motor;
        this.categoria = categoria;
        this.piloto = piloto;
        this.equipo = equipo;
        this.patrocinador = patrocinador;
        this.motorinfo = motorinfo;
    }

    public Long getId_coche() {
        return id_coche;
    }

    public void setId_coche(Long id_coche) {
        this.id_coche = id_coche;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public int getDorsal() {
        return dorsal;
    }

    public void setDorsal(int dorsal) {
        this.dorsal = dorsal;
    }

    public String getMotor() {
        return motor;
    }

    public void setMotor(String motor) {
        this.motor = motor;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public Piloto getPiloto() {
        return piloto;
    }

    public void setPiloto(Piloto piloto) {
        this.piloto = piloto;
    }

    public Equipo getEquipo() {
        return equipo;
    }

    public void setEquipo(Equipo equipo) {
        this.equipo = equipo;
    }

    public PatrocinadorOficial getPatrocinador() {
        return patrocinador;
    }

    public void setPatrocinador(PatrocinadorOficial patrocinador) {
        this.patrocinador = patrocinador;
    }

    public MotorInfo getMotorinfo() {
        return motorinfo;
    }

    public void setMotorinfo(MotorInfo motorinfo) {
        this.motorinfo = motorinfo;
    }

    @Override
    public String toString() {
        return "Coche [id_coche=" + id_coche + ", modelo=" + modelo + ", dorsal=" + dorsal + ", motor=" + motor
                + ", categoria=" + categoria + ", piloto=" + piloto + "equipo=" + equipo
                + ", patrocinador=" + patrocinador + ", motorinfo=" + motorinfo + "]";
    }

}
