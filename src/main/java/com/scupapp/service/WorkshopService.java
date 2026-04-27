package com.scupapp.service;

import com.scupapp.dto.input.WorkshopInputDTO;
import com.scupapp.dto.output.WorkshopOutputDTO;
import org.springframework.http.ResponseEntity;

public interface WorkshopService {

    ResponseEntity<String> createWorkshop(WorkshopInputDTO workshop);

    ResponseEntity<WorkshopOutputDTO> updateWorkshop(Long id, WorkshopInputDTO workshop);

    ResponseEntity<String> deleteWorkshop(Long id);

    ResponseEntity<WorkshopOutputDTO> getWorkshop(Long id);

    ResponseEntity<WorkshopOutputDTO> assignTemaToWorkshop(Long temaId, Long workshopInputDTO);

    ResponseEntity<WorkshopOutputDTO> assignMentorToWorkshop(Long mentorId, Long workshopId);
}
