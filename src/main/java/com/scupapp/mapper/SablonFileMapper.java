package com.scupapp.mapper;


import com.scupapp.dto.input.SablonFileInputDTO;
import com.scupapp.entity.SablonFile;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface SablonFileMapper {

    SablonFile toEntity(SablonFileInputDTO sablonFileInputDTO);
}
