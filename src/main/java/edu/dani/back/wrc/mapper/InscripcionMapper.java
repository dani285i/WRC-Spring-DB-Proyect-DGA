package edu.dani.back.wrc.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import edu.dani.back.wrc.model.Inscripcion;
import edu.dani.back.wrc.model.dto.InscripcionDTO;

@Mapper(componentModel = "spring")
public abstract class InscripcionMapper {

    @Mapping(target = "id_inscripcion", ignore = true)
    
    @Mapping(source = "numero_entrada", target = "numeroEntrada")

    @Mapping(target = "tramo", ignore = true)
    @Mapping(target = "piloto", ignore = true)

    public abstract Inscripcion toEntity(InscripcionDTO dto);

    @Mapping(source = "numeroEntrada", target = "numero_entrada")

    @Mapping(source = "categoria", target = "categoria") 
    
    public abstract InscripcionDTO toDto(Inscripcion entity);

    @Mapping(target = "id_inscripcion", ignore = true)
    @Mapping(source = "numero_entrada", target = "numeroEntrada")

    @Mapping(target = "tramo", ignore = true)
    @Mapping(target = "piloto", ignore = true)

    public abstract void updateInscripcionFromDto(InscripcionDTO dto, @MappingTarget Inscripcion entity);

}