package com.scupapp.mapper;


import com.scupapp.dto.input.KapcsolattartoInputDTO;
import com.scupapp.dto.output.KapcsolattartoOutputDTO;
import com.scupapp.entity.Kapcsolattarto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface KapcsolattartoMapper {

    Kapcsolattarto toEntity(KapcsolattartoInputDTO kapcsolattarto);

    KapcsolattartoOutputDTO toDto(Kapcsolattarto kapcsolattarto);

}
