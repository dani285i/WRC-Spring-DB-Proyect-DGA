package edu.dani.back.wrc.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import edu.dani.back.wrc.model.Rally;
import edu.dani.back.wrc.model.dto.RallyDTO;

@Mapper(componentModel = "spring")
public abstract class RallyMapper {

    @Mapping(target = "id_rally", ignore = true)
    
    @Mapping(target = "equipo", ignore = true)
    @Mapping(target = "etapas", ignore = true)

    public abstract Rally toEntity(RallyDTO dto);

    @Mapping(source = "id_rally", target = "id_Rally")

    public abstract RallyDTO toDto(Rally entity);

    @Mapping(target = "id_rally", ignore = true)
    @Mapping(target = "equipo", ignore = true)
    @Mapping(target = "etapas", ignore = true)
    
    public abstract void updateRallyFromDto(RallyDTO dto, @MappingTarget Rally entity);
}