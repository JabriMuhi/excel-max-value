package org.jabrimuhi.excelmaxvalue.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.jabrimuhi.excelmaxvalue.dto.TopNValueRequestDTO;
import org.jabrimuhi.excelmaxvalue.service.AppService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping("api")
@Tag(name = "Excel Operations")
public class AppController {
    private final AppService appService;

    @PostMapping("/get_top_n_value")
    @Operation(
            summary = "Получить N-ое макисмальное значение",
            description = "Возвращает N-ный максимум из данных Excel файла.<br>" +
                    "Для корректной работы алгоритма экранируйте обратный слеш, или передавайте путь в формате:<br>" +
                    " path/to/your/file.xlsx",
            responses = {
                    @ApiResponse(responseCode = "200"),
                    @ApiResponse(responseCode = "500"),

}
    )

public ResponseEntity<Integer> getTopNMaxValue(@RequestBody TopNValueRequestDTO request) throws Exception {
    Integer result = appService.getTopNMaxValue(request.getFilePath(), request.getTopN());

    return ResponseEntity.ok(result);
}
}
