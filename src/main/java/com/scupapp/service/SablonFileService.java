package com.scupapp.service;

import com.scupapp.dto.input.SablonFileInputDTO;
import com.scupapp.dto.output.SablonFileOutputDTO;

public interface SablonFileService {

    String createSablonFile(SablonFileInputDTO sablonFileInputDTO);

    SablonFileOutputDTO updateSablonFile(Long id, SablonFileInputDTO sablonFileInputDTO);

    String deleteSablonFile(Long id);

    SablonFileOutputDTO getSablonFile(Long id);
}
