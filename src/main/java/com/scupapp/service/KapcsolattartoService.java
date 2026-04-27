package com.scupapp.service;

import com.scupapp.dto.input.KapcsolattartoInputDTO;
import org.springframework.http.ResponseEntity;

public interface KapcsolattartoService {

    ResponseEntity<String> createKapcsolattarto(KapcsolattartoInputDTO kapcsolattarto);

}
