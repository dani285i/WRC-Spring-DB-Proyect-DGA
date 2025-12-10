package edu.dani.back.wrc.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.ReportingPolicy;
import edu.dani.back.wrc.model.Inscripcion;
import edu.dani.back.wrc.model.dto.InscripcionDTO;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public abstract class InscripcionMapper {

    @Mapping(target = "piloto.id_piloto", source = "idPiloto")
    @Mapping(target = "tramo.id_tramo", source = "idTramo")
    
    public abstract Inscripcion toEntity(InscripcionDTO dto);

    @Mapping(source = "id_inscripcion", target = "id_inscripcion")
    @Mapping(source = "piloto.id_piloto", target = "idPiloto")
    @Mapping(source = "tramo.id_tramo", target = "idTramo")

    public abstract InscripcionDTO toDto(Inscripcion entity);

    @Mapping(target = "piloto.id_piloto", source = "idPiloto")
    @Mapping(target = "tramo.id_tramo", source = "idTramo")

    public abstract void updateInscripcionFromDto(InscripcionDTO dto, @MappingTarget Inscripcion entity);
}