package com.scupapp.serviceImpl;


import com.scupapp.dto.input.SablonFileInputDTO;
import com.scupapp.dto.output.SablonFileOutputDTO;
import com.scupapp.entity.SablonFile;
import com.scupapp.mapper.SablonFileMapper;
import com.scupapp.repository.SablonFileRepository;
import com.scupapp.service.SablonFileService;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@AllArgsConstructor
public class SablonFileServiceImpl implements SablonFileService {

    private final SablonFileMapper sablonFileMapper;

    private final SablonFileRepository sablonFileRepository;

    @Override
    public String createSablonFile(SablonFileInputDTO sablonFileInputDTO){
        SablonFile entity = sablonFileMapper.toEntity(sablonFileInputDTO);
        try {
            sablonFileRepository.save(entity);
            return "Sablonfile elmentve";
        } catch(Exception e){
            log.error(e.getMessage());
            return "Hiba";
        }
    }

    @Override
    @Transactional
    public SablonFileOutputDTO updateSablonFile(Long id, SablonFileInputDTO sablonFileInputDTO){
        SablonFile entity = sablonFileRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Nincs"));
        if(sablonFileInputDTO.get)
    }

}
