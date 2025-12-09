package edu.dani.back.wrc.model.dto;

import edu.dani.back.wrc.model.enums.Categoria;

public record CocheDTO(
    Long id_Coche,
    String modelo,
    Integer dorsal,
    String motor,
    Categoria categoria,
    Double potenciaCv,
    Double parMotorNm,
    Integer cilindradaCc,
    Boolean esHibrido

) {}