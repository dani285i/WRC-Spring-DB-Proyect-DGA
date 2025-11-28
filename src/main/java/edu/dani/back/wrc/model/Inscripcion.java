package edu.dani.back.wrc.model;

import edu.dani.back.wrc.model.enums.Categoria;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
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
    private Long id_inscipcion;

    @Column(name="numero_entrada", nullable = false)
    private Integer numeroEntrada;

    @Enumerated(EnumType.STRING)
    @Column(name="categoria", nullable = false)
    private Categoria categoria;

    //Etapa manda sobre inscripcion
    @ManyToOne
    @JoinColumn(name="id_etapa", nullable = false)
    private Etapa etapa;

    public Inscripcion() {
    }

    public Inscripcion(int numeroEntrada, Categoria categoria) {
        this.numeroEntrada = numeroEntrada;
        this.categoria = categoria;
    }

    public Inscripcion(Long id_inscipcion, int numeroEntrada, Categoria categoria) {
        this.id_inscipcion = id_inscipcion;
        this.numeroEntrada = numeroEntrada;
        this.categoria = categoria;
    }

    public Long getId_inscipcion() {
        return id_inscipcion;
    }

    public void setId_inscipcion(Long id_inscipcion) {
        this.id_inscipcion = id_inscipcion;
    }

    public int getNumeroEntrada() {
        return numeroEntrada;
    }

    public void setNumeroEntrada(int numeroEntrada) {
        this.numeroEntrada = numeroEntrada;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    @Override
    public String toString() {
        return "Inscripcion [id_inscipcion=" + id_inscipcion + ", numeroEntrada=" + numeroEntrada + ", categoria="
                + categoria + "]";
    }

}
