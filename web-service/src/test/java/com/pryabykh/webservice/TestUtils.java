package com.pryabykh.webservice;

import com.pryabykh.webservice.dtos.SolutionDto;

public class TestUtils {
    public static SolutionDto shapeSolutionDto() {
        SolutionDto solutionDto = new SolutionDto();
        solutionDto.setFormula("x^2 + 2x + 1 = 0");
        solutionDto.setD(20);
        solutionDto.setX1(1.0);
        solutionDto.setX2(2.0);
        solutionDto.setError(null);
        return solutionDto;
    }
}
