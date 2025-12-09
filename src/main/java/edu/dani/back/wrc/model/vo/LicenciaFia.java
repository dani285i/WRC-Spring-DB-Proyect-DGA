package edu.dani.back.wrc.model.vo;

import jakarta.persistence.Embeddable;
import java.time.LocalDate;

@Embeddable
public class LicenciaFia {

    private final String numero_licencia;
    private final LocalDate fecha_caducidad;
    private final String grupo_sanguineo;

    public LicenciaFia(String numero_licencia, LocalDate fecha_caducidad, String grupo_sanguineo) {
        this.numero_licencia = numero_licencia;
        this.fecha_caducidad = fecha_caducidad;
        this.grupo_sanguineo = grupo_sanguineo;
    }

    public String getNumero_licencia() {
        return numero_licencia;
    }
    public LocalDate getFecha_caducidad() {
        return fecha_caducidad;
    }
    public String getGrupo_sanguineo() {
        return grupo_sanguineo;
    }

}