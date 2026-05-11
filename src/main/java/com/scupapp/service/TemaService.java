package com.scupapp.service;

import com.scupapp.dto.input.TemaInputDTO;
import com.scupapp.dto.output.TemaOutputDTO;

public interface TemaService {

    String createTema(TemaInputDTO temaInputDTO);

    TemaOutputDTO updateTema(Long id, TemaInputDTO temaInputDTO);

    String deleteTema(Long id);

    TemaOutputDTO getTema(Long id);
}
