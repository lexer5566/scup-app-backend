package com.scupapp.dto.input;


import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class FileEntityInputDTO {

    @NotNull
    private Long id;

    private String fileName;

    private String contentType;

    private String filePath;

    private LocalDateTime createdDate;
}
