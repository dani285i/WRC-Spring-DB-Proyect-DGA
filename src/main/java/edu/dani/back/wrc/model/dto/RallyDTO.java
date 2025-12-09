package edu.dani.back.wrc.model.dto;

public record RallyDTO(
    
    Long id_Rally,
    String nombre,
    String pais,
    String fechaComienzo,
    String fechaFin

) {}
