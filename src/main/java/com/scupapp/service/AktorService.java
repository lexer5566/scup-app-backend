package com.scupapp.service;

import com.scupapp.dto.input.AktorInputDTO;
import com.scupapp.dto.output.AktorOutputDTO;

public interface AktorService {

    String createAktor(AktorInputDTO aktorInputDTO);

    AktorOutputDTO updateAktor(Long id, AktorInputDTO aktorInputDTO);

    String deleteAktor(Long id);

    AktorOutputDTO getAktor(Long id);
}
