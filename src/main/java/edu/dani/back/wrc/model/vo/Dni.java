package edu.dani.back.wrc.model.vo;

import jakarta.persistence.Embeddable;

@Embeddable
public class Dni {
    
    private String numero_dni;
    private char letra_dni;

    public Dni() {
    }

    public Dni(String numeroDni, char letraDni) {
        this.numero_dni = numeroDni;
        this.letra_dni = letraDni;
    }

    public String getNumero_dni() {
        return numero_dni;
    }

    public void setNumero_dni(String numero_dni) {
        this.numero_dni = numero_dni;
    }

    public char getLetra_dni() {
        return letra_dni;
    }

    public void setLetra_dni(char letra_dni) {
        this.letra_dni = letra_dni;
    }
}