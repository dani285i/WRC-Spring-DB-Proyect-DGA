package edu.dani.back.wrc.model.vo;

import jakarta.persistence.Embeddable;

@Embeddable
public class Dni {

    private final String numeroDni;
    private final char letraDni;
    
    public Dni(String numeroDni, char letraDni) {
        this.numeroDni = numeroDni;
        this.letraDni = letraDni;
    }

    public String getNumeroDni() {
        return numeroDni;
    }

    public char getLetraDni() {
        return letraDni;
    }
    
}
