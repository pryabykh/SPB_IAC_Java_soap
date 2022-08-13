package com.pryabykh.webservice.services;

import com.pryabykh.webservice.dtos.SolutionDto;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotNull;

@Validated
public interface EquationService {
    SolutionDto solve(@NotNull Integer a, @NotNull Integer b, @NotNull Integer c);
}
