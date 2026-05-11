package com.scupapp.service;

import com.scupapp.dto.input.FileEntityInputDTO;
import com.scupapp.dto.output.FileEntityOutputDTO;

public interface FileEntityService {

    String createFileEntity(FileEntityInputDTO fileEntity);

    FileEntityOutputDTO updateFileEntity(Long id, FileEntityInputDTO fileEntity);

    String deleteFileEntity(Long id);

    FileEntityOutputDTO getFileEntity(Long id);
}
