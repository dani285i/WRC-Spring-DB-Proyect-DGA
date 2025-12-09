package edu.dani.back.wrc.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import edu.dani.back.wrc.model.Tramo;
import edu.dani.back.wrc.model.dto.TramoDTO;

@Mapper(componentModel = "spring")
public abstract class TramoMapper {

    @Mapping(target = "id_tramo", ignore = true)

    @Mapping(target = "rally", ignore = true)
    @Mapping(target = "inscripcion", ignore = true)

    @Mapping(target = "localizacion", expression = "java(new edu.dani.back.wrc.model.vo.CoordenadasGPS(dto.latitud(), dto.longitud(), dto.altitud()))")
    
    public abstract Tramo toEntity(TramoDTO dto);

    @Mapping(source = "id_tramo", target = "id_Tramo")
    
    @Mapping(source = "rally.id_rally", target = "id_Rally")

    @Mapping(source = "localizacion.latitud", target = "latitud")
    @Mapping(source = "localizacion.longitud", target = "longitud")
    @Mapping(source = "localizacion.altitudSobreElMar", target = "altitud")

    public abstract TramoDTO toDto(Tramo entity);

    @Mapping(target = "id_tramo", ignore = true)
    @Mapping(target = "rally", ignore = true)
    @Mapping(target = "inscripcion", ignore = true)
    @Mapping(target = "localizacion", expression = "java(new edu.dani.back.wrc.model.vo.CoordenadasGPS(dto.latitud(), dto.longitud(), dto.altitud()))")
    
    public abstract void updateTramoFromDto(TramoDTO dto, @MappingTarget Tramo entity);
}