package com.scupapp.serviceImpl;

import com.scupapp.dto.input.TemaInputDTO;
import com.scupapp.dto.output.TemaOutputDTO;
import com.scupapp.entity.Tema;
import com.scupapp.mapper.TemaMapper;
import com.scupapp.repository.TemaRepository;
import com.scupapp.service.TemaService;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@AllArgsConstructor
public class TemaServiceImpl implements TemaService {

    private final TemaMapper temaMapper;

    private final TemaRepository temaRepository;

    @Override
    public String createTema(TemaInputDTO temaInputDTO){
        Tema entity = temaMapper.toEntity(temaInputDTO);
        try{
            temaRepository.save(entity);
            return "Tema elmentve";
        } catch(Exception e){
            log.error(e.getMessage());
            return "Hiba";
        }
    }

    @Override
    @Transactional
    public TemaOutputDTO updateTema(Long id, TemaInputDTO temaInputDTO) {
        Tema entity = temaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Nincs"));
        if (temaInputDTO.getNev() != null) {
            entity.setNev(temaInputDTO.getNev());
        }
        if (temaInputDTO.getLeiras() != null) {
            entity.setLeiras(temaInputDTO.getLeiras());
        }

        TemaOutputDTO response = temaMapper.toDto(entity);

        return response;
    }

    @Override
    public String deleteTema(Long id) {
        if (temaRepository.existsById(id)) {
            temaRepository.deleteById(id);
            return "Tema törölve";
        }else  {
            return "Tema not found";
        }
    }

    @Override
    public TemaOutputDTO getTema(Long id) {
        return temaRepository.findById(id)
                .map(temaMapper::toDto)
                .orElseThrow(() -> new EntityNotFoundException("Nincs ilyen!"));
    }
}
