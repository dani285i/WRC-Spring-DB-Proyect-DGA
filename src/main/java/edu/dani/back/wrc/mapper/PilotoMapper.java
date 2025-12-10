package edu.dani.back.wrc.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.ReportingPolicy;

import edu.dani.back.wrc.model.Piloto;
import edu.dani.back.wrc.model.dto.PilotoDTO;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public abstract class PilotoMapper {
    
    @Mapping(target = "dni", expression = "java(new edu.dani.back.wrc.model.vo.Dni(dto.dniNumero(), dto.dniLetra()))")
    @Mapping(target = "licenciafia", expression = "java(new edu.dani.back.wrc.model.vo.LicenciaFia(dto.licNumero(), dto.licFechaCaducidad() != null ? java.time.LocalDate.parse(dto.licFechaCaducidad()) : null, dto.licGrupoSanguineo()))")

    public abstract Piloto toEntity(PilotoDTO dto);

    @Mapping(source = "id_piloto", target = "id_Piloto")
    @Mapping(source = "dni.numero_dni", target = "dniNumero")
    @Mapping(source = "dni.letra_dni", target = "dniLetra")
    
    @Mapping(source = "licenciafia.numero_licencia", target = "licNumero")
    @Mapping(source = "licenciafia.fecha_caducidad", target = "licFechaCaducidad") 
    @Mapping(source = "licenciafia.grupo_sanguineo", target = "licGrupoSanguineo")

    public abstract PilotoDTO toDto(Piloto entity);

    @Mapping(target = "dni", expression = "java(new edu.dani.back.wrc.model.vo.Dni(dto.dniNumero(), dto.dniLetra()))")
    @Mapping(target = "licenciafia", expression = "java(new edu.dani.back.wrc.model.vo.LicenciaFia(dto.licNumero(), dto.licFechaCaducidad() != null ? java.time.LocalDate.parse(dto.licFechaCaducidad()) : null, dto.licGrupoSanguineo()))")
    
    public abstract void updatePilotoFromDto(PilotoDTO dto, @MappingTarget Piloto entity);
}