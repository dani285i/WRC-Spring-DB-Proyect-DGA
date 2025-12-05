package edu.dani.back.wrc.model;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import edu.dani.back.wrc.model.enums.Categoria;
import jakarta.persistence.Column;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Table;

@Entity
@Table(name = "inscripcion")
public class Inscripcion {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_inscripcion;

    @Column(name="numero_entrada", nullable = false)
    private Integer numeroEntrada;

    //Tramo manda sobre inscripcion
    @ManyToOne
    @JoinColumn(name = "id_tramo")
    private Tramo tramo;
    
    @Enumerated(EnumType.STRING)
    @Column(name="categoria", nullable = false)
    private Categoria categoria;

    // Piloto manda sobre Inscripicion
    @ManyToOne
    @JoinColumn(name="piloto_id", nullable = true)
    private Piloto piloto;

    public Inscripcion() {
    }

    public Long getId_inscripcion() {
        return id_inscripcion;
    }

    public void setId_inscripcion(Long id_inscipcion) {
        this.id_inscripcion = id_inscipcion;
    }

    public Integer getNumeroEntrada() {
        return numeroEntrada;
    }

    public void setNumeroEntrada(Integer numeroEntrada) {
        this.numeroEntrada = numeroEntrada;
    }

    public Tramo getTramo() {
        return tramo;
    }

    public void setTramo(Tramo tramo) {
        this.tramo = tramo;
    }

    public Piloto getPiloto() {
        return piloto;
    }

    public void setPiloto(Piloto piloto) {
        this.piloto = piloto;
    }

    @Override
    public String toString() {
        return "Inscripcion [id_inscipcion=" + id_inscripcion + ", numeroEntrada=" + numeroEntrada + "]";
    }

}
