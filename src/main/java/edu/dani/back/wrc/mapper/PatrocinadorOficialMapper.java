package edu.dani.back.wrc.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.ReportingPolicy;

import edu.dani.back.wrc.model.PatrocinadorOficial;
import edu.dani.back.wrc.model.dto.PatrocinadorOficialDTO;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public abstract class PatrocinadorOficialMapper {
    
    @Mapping(source = "nombre", target = "nombre_patrocinador")
    @Mapping(source = "sectorIndustria", target = "sector_industria")
    @Mapping(source = "paginaWeb", target = "pagina_web")
    public abstract PatrocinadorOficial toEntity(PatrocinadorOficialDTO dto);

    @Mapping(source = "id_patrocinador", target = "id_Patrocinador")
    @Mapping(source = "nombre_patrocinador", target = "nombre")
    @Mapping(source = "sector_industria", target = "sectorIndustria")
    @Mapping(source = "pagina_web", target = "paginaWeb")
    public abstract PatrocinadorOficialDTO toDto(PatrocinadorOficial entity);

    @Mapping(source = "nombre", target = "nombre_patrocinador")
    @Mapping(source = "sectorIndustria", target = "sector_industria")
    @Mapping(source = "paginaWeb", target = "pagina_web")
    public abstract void updatePatrocinadorFromDto(PatrocinadorOficialDTO dto, @MappingTarget PatrocinadorOficial entity);

}