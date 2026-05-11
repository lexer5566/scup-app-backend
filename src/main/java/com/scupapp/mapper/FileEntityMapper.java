package com.scupapp.mapper;


import com.scupapp.dto.input.FileEntityInputDTO;
import com.scupapp.dto.output.FileEntityOutputDTO;
import com.scupapp.entity.FileEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface FileEntityMapper {

    FileEntity toEntity(FileEntityInputDTO fileEntityInputDTO);

    FileEntityOutputDTO toDto(FileEntity fileEntity);
}
