package edu.dani.back.wrc.model.dto;

public record PilotoDTO(

    Long id_Piloto,
    String nombre,
    String apellidos,
    String nacionalidad,
    String fechaNacimiento

) {}
