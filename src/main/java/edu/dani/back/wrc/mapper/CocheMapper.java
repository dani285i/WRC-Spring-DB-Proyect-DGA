package edu.dani.back.wrc.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import edu.dani.back.wrc.model.Coche;
import edu.dani.back.wrc.model.dto.CocheDTO;

@Mapper(componentModel = "spring")
public abstract class CocheMapper {

    @Mapping(target = "id_coche", ignore = true)

    @Mapping(target = "motorinfo", expression = "java(new edu.dani.back.wrc.model.vo.MotorInfo(dto.potenciaCv(), dto.parMotorNm(), dto.cilindradaCc(), dto.esHibrido()))")

    @Mapping(target = "piloto", ignore = true)
    @Mapping(target = "equipo", ignore = true)
    @Mapping(target = "patrocinador", ignore = true)

    public abstract Coche toEntity(CocheDTO dto);

    @Mapping(source = "id_coche", target = "id_Coche") 

    @Mapping(source = "motorinfo.potencia_cv", target = "potenciaCv")
    @Mapping(source = "motorinfo.par_motor_nm", target = "parMotorNm")
    @Mapping(source = "motorinfo.cilindradaCc", target = "cilindradaCc")
    @Mapping(source = "motorinfo.es_hibrido", target = "esHibrido")
    
    public abstract CocheDTO toDto(Coche entity);

    @Mapping(target = "id_coche", ignore = true)
    @Mapping(target = "motorinfo", expression = "java(new edu.dani.back.wrc.model.vo.MotorInfo(dto.potenciaCv(), dto.parMotorNm(), dto.cilindradaCc(), dto.esHibrido()))")
    @Mapping(target = "piloto", ignore = true)
    @Mapping(target = "equipo", ignore = true)
    @Mapping(target = "patrocinador", ignore = true)

    public abstract void updateCocheFromDto(CocheDTO dto, @MappingTarget Coche entity);

}