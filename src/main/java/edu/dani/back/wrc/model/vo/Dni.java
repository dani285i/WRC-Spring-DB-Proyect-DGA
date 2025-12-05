package edu.dani.back.wrc.model.vo;

import jakarta.persistence.Embeddable;

@Embeddable
public class Dni {

    private final String numero_dni;
    private final char letra_dni;
    
    public Dni(String numeroDni, char letraDni) {
        this.numero_dni = numeroDni;
        this.letra_dni = letraDni;
    }

    public String getNumero_dni() {
        return numero_dni;
    }

    public char getLetra_dni() {
        return letra_dni;
    }
    
}
