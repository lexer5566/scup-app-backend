package com.scupapp.mapper;

import com.scupapp.dto.input.WorkshopInputDTO;
import com.scupapp.dto.output.WorkshopOutputDTO;
import com.scupapp.entity.Workshop;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface WorkshopMapper {

    Workshop toEntity(WorkshopInputDTO workshopInputDTO);

    WorkshopOutputDTO toDto(Workshop workshop);

}
