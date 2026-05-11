package com.scupapp.controller;

import com.scupapp.dto.input.WorkshopInputDTO;
import com.scupapp.dto.output.WorkshopOutputDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/workshop")
public interface WorkshopController {

    @PostMapping
    ResponseEntity<String> createWorkshop(@RequestBody WorkshopInputDTO workshopInputDTO);

    @PostMapping("/assignTema/{temaId}/{workshopId}")
    ResponseEntity<WorkshopOutputDTO> assignTemaToWorkshop(@PathVariable Long temaId, @PathVariable Long workshopId);

    @DeleteMapping("/removeTema/{workshopId}")
    ResponseEntity<WorkshopOutputDTO> removeTemaFromWorkshop(@PathVariable Long workshopId);

    @PostMapping("/updateTema/{temaId}/{workshopId}")
    ResponseEntity<WorkshopOutputDTO> updateTemaToWorkshop(@PathVariable Long temaId, @PathVariable Long workshopId);

    @PostMapping("/assignMentor/{mentorId}/{workshopId}")
    ResponseEntity<WorkshopOutputDTO> assignMentorToWorkshop(@PathVariable Long mentorId, @PathVariable Long workshopId);

    @DeleteMapping("/removeMentor/{mentorId}/{workshopId}")
    ResponseEntity<WorkshopOutputDTO> removeMentorFromWorkshop(@PathVariable Long mentorId, @PathVariable Long workshopId);

}
