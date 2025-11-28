package edu.dani.back.wrc.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
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

    @ManyToOne
    @JoinColumn(name = "piloto_id", nullable = false)
    private Piloto piloto;

    @ManyToOne
    @JoinColumn(name = "copiloto_id", nullable = false)
    private Piloto copiloto;

    //Manda equipo
    @ManyToOne
    @JoinColumn(name = "equipo_id", nullable = false)
    private Equipo equipo;

    @ManyToOne
    @JoinColumn(name = "id_patrocinador", nullable = false)
    private Patrocinador patrocinador;

    public Coche() {
    }

    public Coche(String modelo, int dorsal, String motor, Piloto piloto, Piloto copiloto) {
        this.modelo = modelo;
        this.dorsal = dorsal;
        this.motor = motor;
    }

    public Coche(Long id_coche, String modelo, int dorsal, String motor, Piloto piloto, Piloto copiloto) {
        this.id_coche = id_coche;
        this.modelo = modelo;
        this.dorsal = dorsal;
        this.motor = motor;
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

    @Override
    public String toString() {
        return "Coche [id_coche=" + id_coche + ", modelo=" + modelo + ", dorsal=" + dorsal + ", motor=" + motor
                + ", piloto=" + piloto + ", copiloto=" + copiloto + "]";
    }
    
}
