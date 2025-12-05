package edu.dani.back.wrc.model.vo;

import jakarta.persistence.Embeddable;

@Embeddable
public class MotorInfo {
    private final Double potencia_cv;
    private final Double par_motor_nm;
    private final Integer cilindrada_cc;
    private final Boolean es_hibrido;

    public MotorInfo(Double potenciaCv, Double parMotorNm, Integer cilindrada_cc, Boolean esHibrido) {
        this.potencia_cv = potenciaCv;
        this.par_motor_nm = parMotorNm;
        this.cilindrada_cc = cilindrada_cc;
        this.es_hibrido = esHibrido;
    }

    public Double getPotencia_cv() {
        return potencia_cv;
    }
    public Double getPar_motor_nm() {
        return par_motor_nm;
    }
    public Integer getCilindradaCc() {
        return cilindrada_cc;
    }
    public Boolean getEs_hibrido() {
        return es_hibrido;
    }

}
