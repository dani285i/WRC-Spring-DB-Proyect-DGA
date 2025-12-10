package edu.dani.back.wrc.model.vo;

import java.math.BigDecimal;

import jakarta.persistence.Embeddable;

@Embeddable
public class CoordenadasGPS {
    
    private BigDecimal latitud;
    private BigDecimal longitud;
    private int altitudSobreElMar;

    public CoordenadasGPS() {
    }

    public CoordenadasGPS(BigDecimal latitud, BigDecimal longitud, int altitudSobreElMar) {
        this.latitud = latitud;
        this.longitud = longitud;
        this.altitudSobreElMar = altitudSobreElMar;
    }

    public BigDecimal getLatitud() {
        return latitud;
    }
    public BigDecimal getLongitud() {
        return longitud;
    }
    public int getaltitudSobreElMar() {
        return altitudSobreElMar;
    }

    
}