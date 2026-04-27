package com.scupapp.dto.output;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TemaOutputDTO {

    private Long id;

    private String nev;

    private String leiras;
}
