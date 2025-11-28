package edu.dani.back.wrc.model.vo;

import jakarta.persistence.Embeddable;

@Embeddable
public class CoordenadasGPS {
    private final Double latitud;
    private final Double longitud;
    private final int altitudSobreElMar;

    public CoordenadasGPS(Double latitud, Double longitud, int altitudSobreElMar) {
        this.latitud = latitud;
        this.longitud = longitud;
        this.altitudSobreElMar = altitudSobreElMar;
    }

    public Double getLatitud() {
        return latitud;
    }
    public Double getLongitud() {
        return longitud;
    }
    public int getaltitudSobreElMar() {
        return altitudSobreElMar;
    }

    
}