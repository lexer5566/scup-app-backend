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
import org.springframework.stereotype.Service;


@Slf4j
@Service
@RequiredArgsConstructor
@Transactional
public class WorkshopServiceImpl implements WorkshopService {

    private final WorkshopMapper workshopMapper;

    private final WorkshopRepository workshopRepository;
    private final TemaRepository temaRepository;
    private final AktorRepository aktorRepository;

    @Override
    public String createWorkshop(WorkshopInputDTO workshopInputDTO) {
        Workshop workshop = workshopMapper.toEntity(workshopInputDTO);
        try{
            workshopRepository.save(workshop);
            return "Workshop létrehozva";
        }catch (Exception e){
            log.error(e.getMessage());
            return "Hiba";
        }
    }

    @Override
    public WorkshopOutputDTO updateWorkshop(Long id, WorkshopInputDTO workshop) {
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

        return response;
    }
    @Override
    public String deleteWorkshop(Long id) {
        if(workshopRepository.existsById(id)) {
            workshopRepository.deleteById(id);
            return "Workshop törölve";
        } else {
            return String.format("Workshop nem taláklható id-vel %d", id);
        }
    }

    @Override
    public WorkshopOutputDTO getWorkshop(Long id) {
        return workshopRepository.findById(id)
                .map(workshopMapper::toDto)
                .orElseThrow(() -> new EntityNotFoundException("Nincs ilyen!"));
    }

    @Override
    public WorkshopOutputDTO assignTemaToWorkshop(Long temaId, Long workshopId) {
        Workshop workshop = workshopRepository.findById(workshopId)
                .orElseThrow(() -> new EntityNotFoundException("Workshop nem található: " + workshopId));

        Tema tema = temaRepository.getReferenceById(temaId);

        workshop.setTema(tema);
        return workshopMapper.toDto(workshop);
    }

    @Override
    public WorkshopOutputDTO assignMentorToWorkshop(Long mentorId, Long workshopId) {
        Workshop workshop = workshopRepository.findById(workshopId)
                .orElseThrow(() -> new EntityNotFoundException("Workshop nem található: " + workshopId));

        Aktor mentor = aktorRepository.getReferenceById(mentorId);

        if (!workshop.getMentorList().contains(mentor)) {
            workshop.getMentorList().add(mentor);
        }

        return workshopMapper.toDto(workshop);
    }

    @Override
    public WorkshopOutputDTO removeMentorFromWorkshop(Long mentorId, Long workshopId) {
        Workshop workshop = workshopRepository.findById(workshopId)
                .orElseThrow(() -> new EntityNotFoundException("Workshop nem található: " + workshopId));

        Aktor mentor = aktorRepository.getReferenceById(mentorId);

        workshop.getMentorList().remove(mentor);

        return workshopMapper.toDto(workshop);
    }

    @Override
    public WorkshopOutputDTO removeTemaFromWorkshop(Long workshopId) {
        Workshop workshop = workshopRepository.findById(workshopId)
                .orElseThrow(() -> new EntityNotFoundException("Workshop nem található: " + workshopId));

        workshop.setTema(null);

        return workshopMapper.toDto(workshop);
    }


}
