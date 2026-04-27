package com.scupapp.serviceImpl;

import com.scupapp.dto.input.KapcsolattartoInputDTO;
import com.scupapp.service.KapcsolattartoService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@AllArgsConstructor
public class KapcsolattartoServiceImpl implements KapcsolattartoService {
    @Override
    public ResponseEntity<String> createKapcsolattarto(KapcsolattartoInputDTO kapcsolattarto) {
        return null;
    }
}
