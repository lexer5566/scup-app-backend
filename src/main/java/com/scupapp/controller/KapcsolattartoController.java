package com.scupapp.controller;

import com.scupapp.dto.output.KapcsolattartoOutputDTO;
import org.springframework.http.ResponseEntity;
import com.scupapp.dto.input.KapcsolattartoInputDTO;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/kapcsolattarto")
public interface KapcsolattartoController {

    @GetMapping("/{id}")
    ResponseEntity<KapcsolattartoOutputDTO> getKapcsolattarto(@PathVariable Long id);

    @PostMapping("/create")
    ResponseEntity<String> createKapcsolattarto(@RequestBody KapcsolattartoInputDTO inputDTO);

    @PostMapping("/{id}")
    ResponseEntity<KapcsolattartoOutputDTO> updateKapcsolattarto(@PathVariable Long id, @RequestBody KapcsolattartoInputDTO inputDTO);

    @DeleteMapping()
    ResponseEntity<String> deleteKapcsolattarto(@RequestParam Long id);

}
