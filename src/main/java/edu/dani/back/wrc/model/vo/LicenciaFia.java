package edu.dani.back.wrc.model.vo;

import jakarta.persistence.Embeddable;
import java.time.LocalDate;

@Embeddable
public class LicenciaFia {

    private String numero_licencia;
    private LocalDate fecha_caducidad;
    private String grupo_sanguineo;

    public LicenciaFia() {
    }

    public LicenciaFia(String numero_licencia, LocalDate fecha_caducidad, String grupo_sanguineo) {
        this.numero_licencia = numero_licencia;
        this.fecha_caducidad = fecha_caducidad;
        this.grupo_sanguineo = grupo_sanguineo;
    }

    public String getNumero_licencia() {
        return numero_licencia;
    }
    public void setNumero_licencia(String numero_licencia) {
        this.numero_licencia = numero_licencia;
    }

    public LocalDate getFecha_caducidad() {
        return fecha_caducidad;
    }
    public void setFecha_caducidad(LocalDate fecha_caducidad) {
        this.fecha_caducidad = fecha_caducidad;
    }

    public String getGrupo_sanguineo() {
        return grupo_sanguineo;
    }
    public void setGrupo_sanguineo(String grupo_sanguineo) {
        this.grupo_sanguineo = grupo_sanguineo;
    }
}