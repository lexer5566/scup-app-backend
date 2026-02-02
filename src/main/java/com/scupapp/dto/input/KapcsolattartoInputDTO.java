package com.scupapp.dto.input;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class KapcsolattartoInputDTO {


    @NotBlank
    private String vezeteknev;

    @NotBlank
    private String keresztnev;

    private String mobil;

    @Email
    private String email;

}
