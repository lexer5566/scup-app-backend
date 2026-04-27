package com.scupapp.service;

import com.scupapp.dto.input.WorkshopInputDTO;
import org.springframework.http.ResponseEntity;

public interface WorkshopService {

    ResponseEntity<String> createWorkshop(WorkshopInputDTO workshopInputDTO);
}
