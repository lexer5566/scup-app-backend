package com.scupapp.dto.input;

import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TemaInputDTO {

    @NotEmpty
    private String nev;

    private String leiras;

}
