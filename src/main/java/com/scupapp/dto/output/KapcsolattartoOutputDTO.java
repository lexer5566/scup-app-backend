package com.scupapp.dto.output;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class KapcsolattartoOutputDTO {

    private Long id;

    private String vezeteknev;

    private String keresztnev;

    private String mobil;

    private String email;

}
