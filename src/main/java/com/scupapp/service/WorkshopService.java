package com.scupapp.service;

import com.scupapp.dto.input.WorkshopInputDTO;
import com.scupapp.dto.output.WorkshopOutputDTO;

public interface WorkshopService {

    String createWorkshop(WorkshopInputDTO workshop);

    WorkshopOutputDTO updateWorkshop(Long id, WorkshopInputDTO workshop);

    String deleteWorkshop(Long id);

    WorkshopOutputDTO getWorkshop(Long id);

    WorkshopOutputDTO assignTemaToWorkshop(Long temaId, Long workshopInputDTO);

    WorkshopOutputDTO assignMentorToWorkshop(Long mentorId, Long workshopId);

    WorkshopOutputDTO removeMentorFromWorkshop(Long mentorId, Long workshopId);

    WorkshopOutputDTO removeTemaFromWorkshop(Long workshopId);
}
