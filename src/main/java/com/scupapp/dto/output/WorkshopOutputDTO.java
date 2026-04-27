package com.scupapp.dto.output;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class WorkshopOutputDTO {

    private Long id;

    private String helyszin;

    private LocalDate datum;

    private LocalDateTime kezdes;

    private int mentorSzam;
}
