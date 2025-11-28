package edu.dani.back.wrc.model.vo;

import jakarta.persistence.Embeddable;

@Embeddable
public class MotorInfo {
    private final Double potenciaCV;
    private final Double parMotorNm;
    private final Integer cilindradaCc;
    private final Boolean esHibrido;

    public MotorInfo(Double potenciaCV, Double parMotorNm, Integer cilindradaCc, Boolean esHibrido) {
        this.potenciaCV = potenciaCV;
        this.parMotorNm = parMotorNm;
        this.cilindradaCc = cilindradaCc;
        this.esHibrido = esHibrido;
    }

    public Double getPotenciaCV() {
        return potenciaCV;
    }
    public Double getParMotorNm() {
        return parMotorNm;
    }
    public Integer getCilindradaCc() {
        return cilindradaCc;
    }
    public Boolean getEsHibrido() {
        return esHibrido;
    }

}
