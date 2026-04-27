package com.scupapp.controllerImpl;


import com.scupapp.controller.WorkshopController;
import com.scupapp.dto.input.WorkshopInputDTO;
import com.scupapp.dto.output.WorkshopOutputDTO;
import com.scupapp.service.WorkshopService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor
public class WorkshopControllerImpl implements WorkshopController {

    private final WorkshopService workshopService;

    @Override
    public ResponseEntity<String> createWorkshop(WorkshopInputDTO workshopInputDTO) {
        try{
            return workshopService.createWorkshop(workshopInputDTO);
        } catch(Exception e){
            log.error(e.getMessage());
        }
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
    }

    @Override
    public ResponseEntity<WorkshopOutputDTO> assignTemaToWorkshop(Long temaId, Long workshopId) {
        try {
            return workshopService.assignTemaToWorkshop(temaId, workshopId);
        } catch (Exception e) {
            log.error(e.getMessage());
        }
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
    }

    @Override
    public ResponseEntity<WorkshopOutputDTO> assignMentorToWorkshop(Long mentorId, Long workshopId) {
        try {
            return workshopService.assignMentorToWorkshop(mentorId, workshopId);
        } catch (Exception e) {
            log.error(e.getMessage());
        }
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
    }
}
