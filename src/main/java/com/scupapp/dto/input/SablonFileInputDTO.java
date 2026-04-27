package com.scupapp.dto.input;


import com.scupapp.entity.FileEntity;
import com.scupapp.entity.Tema;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SablonFileInputDTO {

    @NotNull
    private Long id;

    private Tema tema;

    private FileEntity file;

    private boolean aktiv;

}
