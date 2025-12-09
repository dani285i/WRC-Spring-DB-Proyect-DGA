package edu.dani.back.wrc.model.converter;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;

import edu.dani.back.wrc.model.vo.LicenciaFia;

@Converter(autoApply = false)
public class LicenciaFiaAttributeConverter implements AttributeConverter<LicenciaFia, String> {

    @Override
    public String convertToDatabaseColumn(LicenciaFia attribute) {
        if (attribute == null) return null;

        String numero = attribute.getNumero_licencia();
        LocalDate fecha = attribute.getFecha_caducidad();
        String sangre = attribute.getGrupo_sanguineo();

        if (numero == null || fecha == null || sangre == null) {
            return null;
        }

        return numero + ";" + fecha.toString() + ";" + sangre;
    }

    @Override
    public LicenciaFia convertToEntityAttribute(String dbData) {
        if (dbData == null || dbData.trim().isEmpty()) return null;

        String[] partes = dbData.split(";");

        if (partes.length < 3) {
            throw new IllegalArgumentException("Formato de Licencia FIA inválido: " + dbData);
        }

        try {
            String numero = partes[0];
            LocalDate fecha = LocalDate.parse(partes[1]); 
            String sangre = partes[2];

            return new LicenciaFia(numero, fecha, sangre);

        } catch (DateTimeParseException e) {
            throw new IllegalArgumentException("Error al leer la fecha de la licencia: " + partes[1], e);
        }
    }
}