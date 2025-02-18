package org.jabrimuhi.excelmaxvalue.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class TopNValueRequestDTO {
    @Schema(description = "Путь к Excel файлу", example = "source/for example.xlsx")
    @JsonProperty(value="file_path", required=true)
    private String filePath;

    @Schema(description = "Номер максимума (например, 1 - первый максимум)", example = "3")
    @JsonProperty(value="top_n", required=true)
    private int topN;
}
