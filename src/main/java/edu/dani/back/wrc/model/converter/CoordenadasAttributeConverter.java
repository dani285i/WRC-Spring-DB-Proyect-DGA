package edu.dani.back.wrc.model.converter;

import java.math.BigDecimal;
import edu.dani.back.wrc.model.vo.CoordenadasGPS;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter(autoApply = false)
public class CoordenadasAttributeConverter implements AttributeConverter<CoordenadasGPS, String> {

    @Override
    public String convertToDatabaseColumn(CoordenadasGPS attribute) {
        if (attribute == null) return null;

        BigDecimal latitud = attribute.getLatitud();
        BigDecimal longitud = attribute.getLongitud();
        Integer altitud = attribute.getaltitudSobreElMar(); 

        if (latitud == null || longitud == null || altitud == null) {
            return null;
        }
        return latitud.toString() + ";" + longitud.toString() + ";" + altitud.toString();
    }

    @Override
    public CoordenadasGPS convertToEntityAttribute(String dbData) {
        if (dbData == null || dbData.trim().isEmpty()) return null;

        String[] partes = dbData.split(";");

        if (partes.length != 3) {
            throw new IllegalArgumentException("Formato de coordenadas inválido (se esperaban 3 valores separados por '" + ";" + "'): " + dbData);
        }

        try {
            BigDecimal latitud = new BigDecimal(partes[0]);
            BigDecimal longitud = new BigDecimal(partes[1]);
            Integer altitud = Integer.valueOf(partes[2]);

            return new CoordenadasGPS(latitud, longitud, altitud);

        } catch (NumberFormatException ex) {
            throw new IllegalArgumentException("Error al convertir los números de las coordenadas: " + dbData, ex);
        }
    }
}