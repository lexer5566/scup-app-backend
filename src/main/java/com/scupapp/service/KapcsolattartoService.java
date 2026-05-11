package com.scupapp.service;

import com.scupapp.dto.input.KapcsolattartoInputDTO;
import com.scupapp.dto.output.KapcsolattartoOutputDTO;

public interface KapcsolattartoService {

    String createKapcsolattarto(KapcsolattartoInputDTO kapcsolattarto);

    KapcsolattartoOutputDTO updateKapcsolattarto(Long id, KapcsolattartoInputDTO kapcsolattartoInputDTO);

    String deleteKapcsolattarto(Long id);

    KapcsolattartoOutputDTO getKapcsolattarto(Long id);

}
