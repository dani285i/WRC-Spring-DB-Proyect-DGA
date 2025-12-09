package edu.dani.back.wrc.model.dto;

public record EquipoDTO(

    Long id_Equipo,
    String nombre,
    String director,
    String paisOrigen
    
) {}