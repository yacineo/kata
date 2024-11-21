package com.kata.backend.controller;

import com.kata.backend.service.IkataService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class KataController {

    private final IkataService kataService;

    public KataController(IkataService kataService) {
        this.kataService = kataService;
    }

    @GetMapping("/transform/{number}")
    public String transform(@PathVariable int number) {
        return kataService.transformNumber(number);
    }
}