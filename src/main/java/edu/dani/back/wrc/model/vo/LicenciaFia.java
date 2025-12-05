package edu.dani.back.wrc.model.vo;

import jakarta.persistence.Embeddable;
import java.time.LocalDate;

@Embeddable
public class LicenciaFia {

    private final String numero_licencia;
    private final LocalDate fecha_caducidad;
    private final String grupo_sanguineo;

    public LicenciaFia(String numeroLicencia, LocalDate fechaCaducidad, String grupoSanguineo) {
        this.numero_licencia = numeroLicencia;
        this.fecha_caducidad = fechaCaducidad;
        this.grupo_sanguineo = grupoSanguineo;
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