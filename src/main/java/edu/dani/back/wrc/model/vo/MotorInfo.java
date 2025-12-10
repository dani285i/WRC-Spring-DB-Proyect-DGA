package edu.dani.back.wrc.model.vo;

import jakarta.persistence.Embeddable;

@Embeddable
public class MotorInfo {

    private Double potencia_cv;
    private Double par_motor_nm;
    private Integer cilindrada_cc;
    private Boolean es_hibrido;

    public MotorInfo() {
    }

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

    public void setPotencia_cv(Double potencia_cv) {
        this.potencia_cv = potencia_cv;
    }

    public void setPar_motor_nm(Double par_motor_nm) {
        this.par_motor_nm = par_motor_nm;
    }

    public void setCilindradaCc(Integer cilindrada_cc) {
        this.cilindrada_cc = cilindrada_cc;
    }

    public void setEs_hibrido(Boolean es_hibrido) {
        this.es_hibrido = es_hibrido;
    }
}