package com.scupapp.service;

import com.scupapp.dto.input.KapcsolattartoInputDTO;
import com.scupapp.dto.output.KapcsolattartoOutputDTO;
import org.springframework.http.ResponseEntity;

public interface KapcsolattartoService {

    ResponseEntity<String> createKapcsolattarto(KapcsolattartoInputDTO kapcsolattarto);

    ResponseEntity<KapcsolattartoOutputDTO> updateKapcsolattarto(Long id, KapcsolattartoInputDTO kapcsolattarto);

    ResponseEntity<String> deleteKapcsolattarto(Long id);

    ResponseEntity<KapcsolattartoOutputDTO> getKapcsolattarto(Long id);

}
