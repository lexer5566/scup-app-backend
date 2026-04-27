package com.scupapp.service;

import com.scupapp.dto.input.WorkshopInputDTO;
import com.scupapp.dto.output.WorkshopOutputDTO;
import org.springframework.http.ResponseEntity;

public interface WorkshopService {

    ResponseEntity<String> createWorkshop(WorkshopInputDTO workshopInputDTO);

    ResponseEntity<WorkshopOutputDTO> assignTemaToWorkshop(Long temaId, Long workshopInputDTO);
}
