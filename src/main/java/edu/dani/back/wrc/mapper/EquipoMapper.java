package edu.dani.back.wrc.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import edu.dani.back.wrc.model.Equipo;
import edu.dani.back.wrc.model.dto.EquipoDTO;

@Mapper(componentModel = "spring")
public abstract class EquipoMapper {

    @Mapping(target = "id_equipo", ignore = true)
    
    @Mapping(target = "coche", ignore = true) 
    @Mapping(target = "rally", ignore = true)
    public abstract Equipo toEntity(EquipoDTO dto);

    @Mapping(source = "id_equipo", target = "id_Equipo")
    public abstract EquipoDTO toDto(Equipo entity);

    @Mapping(target = "id_equipo", ignore = true)
    @Mapping(target = "coche", ignore = true)
    @Mapping(target = "rally", ignore = true)
    public abstract void updateEquipoFromDto(EquipoDTO dto, @MappingTarget Equipo entity);
}