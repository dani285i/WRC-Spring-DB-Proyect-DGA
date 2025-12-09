package edu.dani.back.wrc.model.dto;

import java.math.BigDecimal;

public record TramoDTO(

    Long id_Tramo,
    String nombre,
    double distancia,
    BigDecimal horaDia,
    String clima,
    String tipoSuperficie

) {}