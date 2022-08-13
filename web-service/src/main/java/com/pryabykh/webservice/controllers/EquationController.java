package com.pryabykh.webservice.controllers;

import com.pryabykh.webservice.dtos.SolutionDto;
import com.pryabykh.webservice.services.EquationService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class EquationController {
    private final EquationService equationService;

    public EquationController(EquationService equationService) {
        this.equationService = equationService;
    }

    @GetMapping("/calc")
    ResponseEntity<SolutionDto> solve(@RequestParam("a") Integer a, @RequestParam("b") Integer b, @RequestParam("c") Integer c) {
        return ResponseEntity.ok(equationService.solve(a, b, c));
    }
}
