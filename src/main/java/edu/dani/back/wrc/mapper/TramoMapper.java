package edu.dani.back.wrc.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.ReportingPolicy;
import edu.dani.back.wrc.model.Tramo;
import edu.dani.back.wrc.model.dto.TramoDTO;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public abstract class TramoMapper {

    @Mapping(target = "localizacion", expression = "java(new edu.dani.back.wrc.model.vo.CoordenadasGPS(dto.latitud(), dto.longitud(), dto.altitud()))")
    @Mapping(target = "rally.id_rally", source = "idRally")
    public abstract Tramo toEntity(TramoDTO dto);

    @Mapping(source = "id_tramo", target = "id_tramo")
    @Mapping(source = "rally.id_rally", target = "idRally")
    @Mapping(source = "localizacion.latitud", target = "latitud")
    @Mapping(source = "localizacion.longitud", target = "longitud")
    @Mapping(source = "localizacion.altitudSobreElMar", target = "altitud")
    public abstract TramoDTO toDto(Tramo entity);

    @Mapping(target = "localizacion", expression = "java(new edu.dani.back.wrc.model.vo.CoordenadasGPS(dto.latitud(), dto.longitud(), dto.altitud()))")
    @Mapping(target = "rally.id_rally", source = "idRally")
    public abstract void updateTramoFromDto(TramoDTO dto, @MappingTarget Tramo entity);
}