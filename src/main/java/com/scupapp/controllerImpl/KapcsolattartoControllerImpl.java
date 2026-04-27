package com.scupapp.controllerImpl;

import com.scupapp.controller.KapcsolattartoController;
import com.scupapp.dto.input.KapcsolattartoInputDTO;
import com.scupapp.dto.output.KapcsolattartoOutputDTO;
import com.scupapp.service.KapcsolattartoService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor
public class KapcsolattartoControllerImpl implements KapcsolattartoController {

    private final KapcsolattartoService kapcsolattartoService;

    @Override
    public ResponseEntity<KapcsolattartoOutputDTO> getKapcsolattarto(Long id) {
        try {
            return kapcsolattartoService.getKapcsolattarto(id);
        } catch (Exception e) {
            log.error(e.getMessage());
        }
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
    }

    @Override
    public ResponseEntity<String> createKapcsolattarto(@RequestBody KapcsolattartoInputDTO inputDTO) {
        try {
            return kapcsolattartoService.createKapcsolattarto(inputDTO);
        } catch (Exception e) {
            log.error(e.getMessage());
        }
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
    }

    @Override
    public ResponseEntity<KapcsolattartoOutputDTO> updateKapcsolattarto(Long id, KapcsolattartoInputDTO inputDTO) {
        try {
            return kapcsolattartoService.updateKapcsolattarto(id, inputDTO);
        } catch (Exception e) {
            log.error(e.getMessage());
        }
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
    }

    @Override
    public ResponseEntity<String> deleteKapcsolattarto(Long id) {
        try {
            return kapcsolattartoService.deleteKapcsolattarto(id);
        } catch (Exception e) {
            log.error(e.getMessage());
        }
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
    }

}
