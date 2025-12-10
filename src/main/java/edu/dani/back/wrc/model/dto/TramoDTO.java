package edu.dani.back.wrc.model.dto;

import java.math.BigDecimal;
import edu.dani.back.wrc.model.enums.Clima;
import edu.dani.back.wrc.model.enums.TipoSuperficie;

public record TramoDTO(
    Long id_tramo,
    String nombre,
    Double distancia,
    BigDecimal horaDia,
    Clima clima,
    TipoSuperficie tipoSuperficie,
    Long idRally,
    BigDecimal latitud,
    BigDecimal longitud,
    Integer altitud
) {}