package edu.dani.back.wrc.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.ReportingPolicy;
import edu.dani.back.wrc.model.Equipo;
import edu.dani.back.wrc.model.dto.EquipoDTO;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public abstract class EquipoMapper {

    @Mapping(target = "rally.id_rally", source = "idRally")

    public abstract Equipo toEntity(EquipoDTO dto);

    @Mapping(source = "id_equipo", target = "id_Equipo")
    @Mapping(source = "rally.id_rally", target = "idRally")
    
    public abstract EquipoDTO toDto(Equipo entity);

    @Mapping(target = "rally.id_rally", source = "idRally")

    public abstract void updateEquipoFromDto(EquipoDTO dto, @MappingTarget Equipo entity);
}