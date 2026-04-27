package com.scupapp.service;

import com.scupapp.dto.input.SablonFileInputDTO;
import com.scupapp.dto.output.SablonFileOutputDTO;
import org.springframework.http.ResponseEntity;

public interface SablonFileService {

    ResponseEntity<SablonFileOutputDTO> createSablonFile(SablonFileInputDTO sablonFile);

    ResponseEntity<SablonFileOutputDTO> updateSablonFile(Long id, SablonFileInputDTO sablonFile);

    ResponseEntity<String> deleteSablonFile(Long id);

    ResponseEntity<SablonFileOutputDTO> getSablonFile(Long id);
}
