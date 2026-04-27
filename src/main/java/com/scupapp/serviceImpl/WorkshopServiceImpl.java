package com.scupapp.serviceImpl;

import com.scupapp.dto.input.WorkshopInputDTO;
import com.scupapp.dto.output.WorkshopOutputDTO;
import com.scupapp.entity.Aktor;
import com.scupapp.entity.Tema;
import com.scupapp.entity.Workshop;
import com.scupapp.mapper.WorkshopMapper;
import com.scupapp.repository.AktorRepository;
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
    private final AktorRepository aktorRepository;

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
    public ResponseEntity<WorkshopOutputDTO> updateWorkshop(Long id, WorkshopInputDTO workshop) {
        Workshop entity = workshopRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Nincs"));

        if (workshop.getHelyszin() != null) {
            entity.setHelyszin(workshop.getHelyszin());
        }
        if(workshop.getDatum() != null) {
            entity.setDatum(workshop.getDatum());
        }
        if(workshop.getKezdes() != null) {
            entity.setKezdes(workshop.getKezdes());
        }
//todo megnézni a mentorszámot
        WorkshopOutputDTO response = workshopMapper.toDto(entity);

        return ResponseEntity.ok().body(response);
    }
    @Override
    public ResponseEntity<String> deleteWorkshop(Long id) {
        if(workshopRepository.existsById(id)) {
            workshopRepository.deleteById(id);
            return ResponseEntity.ok().body("Workshop deleted successfully");
        } else {
            return ResponseEntity.badRequest().body("Workshop not found");
        }
    }

    @Override
    public ResponseEntity<WorkshopOutputDTO> getWorkshop(Long id) {
        return workshopRepository.findById(id)
                .map(workshopMapper::toDto)
                .map(ResponseEntity::ok)
                .orElseThrow(() -> new EntityNotFoundException("Nincs ilyen!"));
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

    @Override
    @Transactional
    public ResponseEntity<WorkshopOutputDTO> assignMentorToWorkshop(Long mentorId, Long workshopId) {
        Workshop workshop = workshopRepository.findById(workshopId)
                .orElseThrow(() -> new EntityNotFoundException("Workshop nem található: " + workshopId));

        Aktor mentor = aktorRepository.getReferenceById(mentorId);

        if (!workshop.getMentorList().contains(mentor)) {
            workshop.getMentorList().add(mentor);
        }

        return ResponseEntity.ok(workshopMapper.toDto(workshop));
    }
}
