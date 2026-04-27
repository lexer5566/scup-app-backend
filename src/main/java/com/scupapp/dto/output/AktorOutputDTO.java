package com.scupapp.dto.output;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AktorOutputDTO {

    private Long id;

    private String felhasznalonev;

    private String email;

    private String vezeteknev;

    private String keresztnev;

    private String mobil;

    private String varos;
}
