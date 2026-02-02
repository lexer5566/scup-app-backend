package com.scupapp.dto.input;

import com.scupapp.entity.Kapcsolattarto;
import com.scupapp.entity.Tema;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
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
public class WorkshopInputDTO {

    @NotEmpty
    private String helyszin;

    @NotEmpty
    private LocalDate datum;

    @NotNull
    private LocalDateTime kezdes;

    @NotEmpty
    private Kapcsolattarto kapcsolattarto;

    @NotNull
    private int mentorSzam;

    private Tema tema;
}
