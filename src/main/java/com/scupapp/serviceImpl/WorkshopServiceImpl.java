package com.scupapp.serviceImpl;

import com.scupapp.dto.input.WorkshopInputDTO;
import com.scupapp.entity.Workshop;
import com.scupapp.mapper.WorkshopMapper;
import com.scupapp.repository.WorkshopRepository;
import com.scupapp.service.WorkshopService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;


@Slf4j
@Service
@RequiredArgsConstructor
public class WorkshopServiceImpl implements WorkshopService {

    private final WorkshopMapper workshopMapper;

    private final WorkshopRepository workshopRepository;

    @Override
    public ResponseEntity<String> createWorkshop(WorkshopInputDTO workshopInputDTO) {
        Workshop workshop = workshopMapper.toEntity(workshopInputDTO);
        try{
            workshopRepository.save(workshop);
            return ResponseEntity.ok().body("Workshop created successfully");
        }catch (Exception e){
            log.error(e.getMessage());
            return ResponseEntity.badRequest().build();
        }
    }
}
