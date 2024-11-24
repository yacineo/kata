package com.kata.backend.controller;

import com.kata.backend.service.IKataService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Tag(
        name = "REST API for FOO BAR QUIX",
        description = "REST APIs in KATA to transform number to string according to FOO BAR QUIX rules"
)
@RestController
@RequestMapping("/api/kata")
@RequiredArgsConstructor
public class KataController {

    private final IKataService kataService;

    @Operation(
            summary = "Transform a number",
            description = "Transforms a number according to the kata rules."
    )
    @ApiResponses({
            @ApiResponse(
                    responseCode = "200",
                    description = "HTTP Status OK"
            ),
            @ApiResponse(
                    responseCode = "400",
                    description = "Bad request"
            ),
            @ApiResponse(
                    responseCode = "500",
                    description = "HTTP Status Internal Server Error"
            )
    }
    )
    @GetMapping("/transform/{number}")
    public ResponseEntity<String> transform(@PathVariable int number) {

        String result = kataService.transformNumber(number);
        return ResponseEntity.ok(result);

    }
}