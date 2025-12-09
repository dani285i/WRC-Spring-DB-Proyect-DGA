package edu.dani.back.wrc.model.dto;

import java.math.BigDecimal;
import edu.dani.back.wrc.model.enums.Clima;
import edu.dani.back.wrc.model.enums.TipoSuperficie;

public record TramoDTO(
    Long id_Tramo,
    String nombre,
    Double distancia,
    BigDecimal horaDia,
    Clima clima,
    TipoSuperficie tipoSuperficie,

    Long id_Rally,

    BigDecimal latitud,
    BigDecimal longitud,
    Integer altitud
) {}