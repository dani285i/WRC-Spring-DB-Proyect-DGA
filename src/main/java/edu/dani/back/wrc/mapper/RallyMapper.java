package edu.dani.back.wrc.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.ReportingPolicy;

import edu.dani.back.wrc.model.Rally;
import edu.dani.back.wrc.model.dto.RallyDTO;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public abstract class RallyMapper {

    public abstract Rally toEntity(RallyDTO dto);

    @Mapping(source = "id_rally", target = "id_Rally")
    public abstract RallyDTO toDto(Rally entity);

    public abstract void updateRallyFromDto(RallyDTO dto, @MappingTarget Rally entity);
    
}