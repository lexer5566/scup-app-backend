package com.scupapp.mapper;


import com.scupapp.dto.input.AktorInputDTO;
import com.scupapp.entity.Aktor;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AktorMapper {

    Aktor toEntity(AktorInputDTO aktorInputDTO);
}
