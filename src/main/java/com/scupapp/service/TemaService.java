package com.scupapp.service;

import com.scupapp.dto.input.TemaInputDTO;
import com.scupapp.dto.output.TemaOutputDTO;
import org.springframework.http.ResponseEntity;

public interface TemaService {

    ResponseEntity<String> createTema(TemaInputDTO tema);

    ResponseEntity<TemaOutputDTO> updateTema(Long id, TemaInputDTO tema);

    ResponseEntity<String> deleteTema(Long id);

    ResponseEntity<TemaOutputDTO> getTema(Long id);
}
