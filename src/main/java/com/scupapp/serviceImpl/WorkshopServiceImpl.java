package com.scupapp.serviceImpl;

import com.scupapp.dto.input.WorkshopInputDTO;
import com.scupapp.dto.output.WorkshopOutputDTO;
import com.scupapp.entity.Tema;
import com.scupapp.entity.Workshop;
import com.scupapp.mapper.WorkshopMapper;
import com.scupapp.repository.TemaRepository;
import com.scupapp.repository.WorkshopRepository;
import com.scupapp.service.WorkshopService;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
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
    private final TemaRepository temaRepository;

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

    @Override
    @Transactional
    public ResponseEntity<WorkshopOutputDTO> assignTemaToWorkshop(Long temaId, Long workshopId) {
        Workshop workshop = workshopRepository.findById(workshopId)
                .orElseThrow(() -> new EntityNotFoundException("Workshop nem található: " + workshopId));

        Tema tema = temaRepository.getReferenceById(temaId);

        workshop.setTema(tema);
        return ResponseEntity.ok(workshopMapper.toDto(workshop));
    }
}
