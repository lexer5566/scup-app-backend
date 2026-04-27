package com.scupapp.controller;

import com.scupapp.dto.input.WorkshopInputDTO;
import com.scupapp.dto.output.WorkshopOutputDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/workshop")
public interface WorkshopController {

    @PostMapping
    ResponseEntity<String> createWorkshop(@RequestBody WorkshopInputDTO workshopInputDTO);

    @PostMapping("/assignTema/{temaId}/{workshopId}")
    ResponseEntity<WorkshopOutputDTO> assignTemaToWorkshop(@PathVariable Long temaId, @PathVariable Long workshopId);

    @PostMapping("/assignMentor/{mentorId}/{workshopId}")
    ResponseEntity<WorkshopOutputDTO> assignMentorToWorkshop(@PathVariable Long mentorId, @PathVariable Long workshopId);
}
