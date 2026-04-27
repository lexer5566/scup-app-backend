package com.scupapp.dto.output;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class FileEntityOutputDTO {

    private Long id;

    private String filename;

}
