package edu.dani.back.wrc.model.converter;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;
import edu.dani.back.wrc.model.vo.Dni;

@Converter(autoApply = false)
public class DniAttributeConverter implements AttributeConverter<Dni, String> {

    @Override
    public String convertToDatabaseColumn(Dni attribute) {
        if (attribute == null) return null;

        String numeroDni = attribute.getNumero_dni();
        Character letraDni = attribute.getLetra_dni();

        if (numeroDni == null || letraDni == null) {
            return null;
        }
        return numeroDni + letraDni;
    }

    @Override
    public Dni convertToEntityAttribute(String dbData) {
        // 1. Validaciones de seguridad
        if (dbData == null || dbData.trim().isEmpty()) return null;
        
        String s = dbData.trim();

        if (s.length() < 2) {
            throw new IllegalArgumentException("Formato de DNI inválido (muy corto): " + dbData);
        }
        String numeroPart = s.substring(0, s.length() - 1);
        char letraPart = s.charAt(s.length() - 1);
        return new Dni(numeroPart, letraPart);
    }
}