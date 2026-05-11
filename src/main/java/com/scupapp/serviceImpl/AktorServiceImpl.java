package com.scupapp.serviceImpl;

import com.scupapp.dto.input.AktorInputDTO;
import com.scupapp.dto.output.AktorOutputDTO;
import com.scupapp.entity.Aktor;
import com.scupapp.mapper.AktorMapper;
import com.scupapp.repository.AktorRepository;
import com.scupapp.service.AktorService;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@AllArgsConstructor
public class AktorServiceImpl implements AktorService {

    private final AktorMapper aktorMapper;

    private final AktorRepository aktorRepository;

    @Override
    public String createAktor(AktorInputDTO aktorInputDTO) {
        Aktor entity = aktorMapper.toEntity(aktorInputDTO);
        try{
            aktorRepository.save(entity);
            return "Aktor created";
        }catch (Exception e){
            log.error(e.getMessage());
            return e.getMessage();
        }
    }

    @Override
    @Transactional
    public AktorOutputDTO updateAktor(Long id, AktorInputDTO aktorInputDTO){
        Aktor entity = aktorRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Nincs"));

        if(aktorInputDTO.getVezeteknev() != null){
            entity.setVezeteknev(aktorInputDTO.getVezeteknev());
        }

        if(aktorInputDTO.getKeresztnev() != null){
            entity.setKeresztnev(aktorInputDTO.getKeresztnev());
        }

        if(aktorInputDTO.getMobil() != null){
            entity.setMobil(aktorInputDTO.getMobil());
        }

        if(aktorInputDTO.getEmail() != null){
            entity.setEmail(aktorInputDTO.getEmail());
        }

    }

    @Override
    public String deleteAktor(Long id) {
        return "";
    }

    @Override
    public AktorOutputDTO getAktor(Long id) {
        return null;
    }
}
