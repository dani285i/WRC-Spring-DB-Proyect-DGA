package edu.dani.back.wrc.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.ReportingPolicy;

import edu.dani.back.wrc.model.Coche;
import edu.dani.back.wrc.model.dto.CocheDTO;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public abstract class CocheMapper {

    @Mapping(target = "motorinfo", expression = "java(new edu.dani.back.wrc.model.vo.MotorInfo(dto.potenciaCv(), dto.parMotorNm(), dto.cilindradaCc(), dto.esHibrido()))")
    @Mapping(source = "idEquipo", target = "equipo.id_equipo")
    @Mapping(source = "idPiloto", target = "piloto.id_piloto")

    public abstract Coche toEntity(CocheDTO dto);

    @Mapping(source = "id_coche", target = "id_Coche") 
    @Mapping(source = "motorinfo.potencia_cv", target = "potenciaCv") 
    @Mapping(source = "motorinfo.par_motor_nm", target = "parMotorNm")
    @Mapping(source = "motorinfo.cilindradaCc", target = "cilindradaCc")
    @Mapping(source = "motorinfo.es_hibrido", target = "esHibrido")

    public abstract CocheDTO toDto(Coche entity);

    @Mapping(target = "motorinfo", expression = "java(new edu.dani.back.wrc.model.vo.MotorInfo(dto.potenciaCv(), dto.parMotorNm(), dto.cilindradaCc(), dto.esHibrido()))")
    
    public abstract void updateCocheFromDto(CocheDTO dto, @MappingTarget Coche entity);

}