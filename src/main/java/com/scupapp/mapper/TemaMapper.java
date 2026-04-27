package com.scupapp.mapper;


import com.scupapp.dto.input.TemaInputDTO;
import com.scupapp.dto.output.TemaOutputDTO;
import com.scupapp.entity.Tema;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface TemaMapper {

    Tema toEntity(TemaInputDTO temaInputDTO);

    TemaOutputDTO toDto(Tema entity);
}
