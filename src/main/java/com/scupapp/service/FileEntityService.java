package com.scupapp.service;

import com.scupapp.dto.input.FileEntityInputDTO;
import com.scupapp.dto.output.FileEntityOutputDTO;
import org.springframework.http.ResponseEntity;

public interface FileEntityService {

    ResponseEntity<String> createFinalEntity(FileEntityInputDTO fileEntity);

    ResponseEntity<FileEntityOutputDTO> createFile(Long id, FileEntityInputDTO fileEntity);

    ResponseEntity<String> deleteFileEntity(Long id);

    ResponseEntity<FileEntityOutputDTO> getFileEntity(Long id);
}
