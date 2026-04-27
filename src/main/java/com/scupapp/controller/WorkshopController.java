package com.scupapp.controller;

import com.scupapp.dto.input.WorkshopInputDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/workshop")
public interface WorkshopController {

    @PostMapping
    ResponseEntity<String> createWorkshop(@RequestBody WorkshopInputDTO workshopInputDTO);
}
