package com.scupapp.service;

import com.scupapp.dto.input.AktorInputDTO;
import com.scupapp.dto.output.AktorOutputDTO;
import org.springframework.http.ResponseEntity;

public interface AktorService {

    ResponseEntity<String> createAktor(AktorInputDTO aktorInputDTO);

    ResponseEntity<AktorOutputDTO> updateAktor(Long id, AktorInputDTO aktorInputDTO);

    ResponseEntity<String> deleteAktor(Long id);

    ResponseEntity<AktorOutputDTO> getAktor(Long id);
}
