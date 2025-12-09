package edu.dani.back.wrc.model.dto;

import edu.dani.back.wrc.model.enums.Categoria;

public record InscripcionDTO(

    Long id_inscripcion,
    int numero_entrada,
    Categoria categoria

) {}
