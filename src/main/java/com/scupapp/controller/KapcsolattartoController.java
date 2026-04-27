package com.scupapp.controller;

import org.springframework.http.ResponseEntity;
import com.scupapp.dto.input.KapcsolattartoInputDTO;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/kapcsolattarto")
public interface KapcsolattartoController {

    @PostMapping("/create")
    ResponseEntity<String> createKapcsolattarto(@RequestBody KapcsolattartoInputDTO inputDTO);

}
