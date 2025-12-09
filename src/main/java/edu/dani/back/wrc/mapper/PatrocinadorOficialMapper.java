package edu.dani.back.wrc.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import edu.dani.back.wrc.model.PatrocinadorOficial;
import edu.dani.back.wrc.model.dto.PatrocinadorOficialDTO;

@Mapper(componentModel = "spring")
public abstract class PatrocinadorOficialMapper {

    @Mapping(target = "id_patrocinador", ignore = true)
    
    @Mapping(target = "coches", ignore = true)
    
    public abstract PatrocinadorOficial toEntity(PatrocinadorOficialDTO dto);

    @Mapping(source = "id_patrocinador", target = "id_Patrocinador")

    public abstract PatrocinadorOficialDTO toDto(PatrocinadorOficial entity);

    @Mapping(target = "id_patrocinador", ignore = true)
    @Mapping(target = "coches", ignore = true)

    public abstract void updatePatrocinadorFromDto(PatrocinadorOficialDTO dto, @MappingTarget PatrocinadorOficial entity);

}