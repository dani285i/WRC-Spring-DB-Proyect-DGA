package edu.dani.back.wrc.model.converter;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;
import edu.dani.back.wrc.model.vo.MotorInfo;

@Converter(autoApply = false)
public class MotorInfoAttributeConverter implements AttributeConverter<MotorInfo, String> {

    @Override
    public String convertToDatabaseColumn(MotorInfo attribute) {
        if (attribute == null) return null;

        Double potencia = attribute.getPotencia_cv();
        Double par = attribute.getPar_motor_nm();
        Integer cilindrada = attribute.getCilindradaCc();
        Boolean esHibrido = attribute.getEs_hibrido();

        if (potencia == null || par == null || cilindrada == null || esHibrido == null) {
            return null;
        }

        return potencia + ";" + par + ";" + cilindrada + ";" + esHibrido;
    }

    @Override
    public MotorInfo convertToEntityAttribute(String dbData) {
        if (dbData == null || dbData.trim().isEmpty()) return null;

        String[] partes = dbData.split(";");

        if (partes.length < 4) {
            throw new IllegalArgumentException("Formato de MotorInfo inválido (faltan datos): " + dbData);
        }

        try {
            Double potencia = Double.valueOf(partes[0]);
            Double par = Double.valueOf(partes[1]);
            Integer cilindrada = Integer.valueOf(partes[2]);
            
            Boolean esHibrido = Boolean.valueOf(partes[3]); 

            return new MotorInfo(potencia, par, cilindrada, esHibrido);

        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Error al convertir los números del motor: " + dbData, e);
        }
    }
}