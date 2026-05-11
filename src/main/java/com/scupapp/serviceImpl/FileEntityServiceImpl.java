package com.scupapp.serviceImpl;

import com.scupapp.dto.input.FileEntityInputDTO;
import com.scupapp.dto.output.FileEntityOutputDTO;
import com.scupapp.entity.FileEntity;
import com.scupapp.mapper.FileEntityMapper;
import com.scupapp.repository.FileEntityRepository;
import com.scupapp.service.FileEntityService;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@AllArgsConstructor
@Transactional
public class FileEntityServiceImpl implements FileEntityService {

    private FileEntityMapper fileEntityMapper;

    private FileEntityRepository fileEntityRepository;

    @Override
    public String createFileEntity(FileEntityInputDTO fileEntityInputDTO){
        FileEntity fileEntity = fileEntityMapper.toEntity(fileEntityInputDTO);
        try{
            fileEntityRepository.save(fileEntity);
            return "FileEntity létrehozva";
        }catch(Exception e){
            log.error(e.getMessage());
            return e.getMessage();
        }
    }

    @Override
    public FileEntityOutputDTO updateFileEntity(Long id, FileEntityInputDTO fileEntityInputDTO){
        FileEntity entity = fileEntityRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Nincs"));
        if(fileEntityInputDTO.getFileName() != null){
            entity.setFilename(fileEntityInputDTO.getFileName());
        }
        if(fileEntityInputDTO.getContentType() != null){
            entity.setContentType(fileEntityInputDTO.getContentType());
        }
        if(fileEntityInputDTO.getFilePath() != null){
            entity.setFilePath(fileEntityInputDTO.getFilePath());
        }

        FileEntityOutputDTO response = fileEntityMapper.toDto(entity);
        return response;
    }

    @Override
    public String deleteFileEntity(Long id){
        if(fileEntityRepository.existsById(id)){
            fileEntityRepository.deleteById(id);
            return "FileEntity deleted";
        }else{
            return "FileEntity not found";
        }
    }

    @Override
    public FileEntityOutputDTO getFileEntity(Long id){
        return fileEntityRepository.findById(id)
                .map(fileEntityMapper::toDto)
                .orElseThrow(() -> new EntityNotFoundException("Nincs"));

    }
}

