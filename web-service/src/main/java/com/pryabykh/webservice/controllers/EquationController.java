package com.pryabykh.webservice.controllers;

import com.pryabykh.webservice.dtos.SolutionDto;
import com.pryabykh.webservice.services.EquationService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.ConstraintViolationException;

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

    @ExceptionHandler({ConstraintViolationException.class})
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<String> handleConstraintViolationException() {
        return new ResponseEntity<>("Bad request", HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler({Exception.class, RuntimeException.class})
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ResponseEntity<String> handleException(Throwable throwable) {
        throwable.printStackTrace();
        return new ResponseEntity<>("Internal server error", HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
