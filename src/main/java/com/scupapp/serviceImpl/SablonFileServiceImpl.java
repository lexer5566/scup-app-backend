package com.scupapp.serviceImpl;


import com.scupapp.dto.input.SablonFileInputDTO;
import com.scupapp.entity.SablonFile;
import com.scupapp.mapper.SablonFileMapper;
import com.scupapp.repository.SablonFileRepository;
import com.scupapp.service.SablonFileService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@AllArgsConstructor
public class SablonFileServiceImpl implements SablonFileService {

    private final SablonFileMapper sablonFileMapper;

    private final SablonFileRepository sablonFileRepository;

    @Override
    public ResponseEntity<String> createSablonFile(SablonFileInputDTO sablonFileInputDTO){
        SablonFile entity = sablonFileMapper.toEntity(sablonFileInputDTO);
        try{
            sablonFileRepository.save(entity);

    }
}
