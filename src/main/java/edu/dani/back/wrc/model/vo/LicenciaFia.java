package edu.dani.back.wrc.model.vo;

import jakarta.persistence.Embeddable;
import java.time.LocalDate;

@Embeddable
public class LicenciaFia {

    private final String numeroLicencia;
    private final LocalDate fechaCaducidad;
    private final String grupoSanguineo;

    public LicenciaFia(String numeroLicencia, LocalDate fechaCaducidad, String grupoSanguineo) {
        this.numeroLicencia = numeroLicencia;
        this.fechaCaducidad = fechaCaducidad;
        this.grupoSanguineo = grupoSanguineo;
    }

    public String getNumeroLicencia() {
        return numeroLicencia;
    }
    public LocalDate getFechaCaducidad() {
        return fechaCaducidad;
    }
    public String getGrupoSanguineo() {
        return grupoSanguineo;
    }

}