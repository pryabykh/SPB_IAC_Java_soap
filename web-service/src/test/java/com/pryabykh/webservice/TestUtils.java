package com.pryabykh.webservice;

import com.pryabykh.webservice.dtos.SolutionDto;
import com.pryabykh.webservice.schemas.equation.QuadraticEquationResponse;

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

    public static QuadraticEquationResponse shapeSoapResponse() {
        QuadraticEquationResponse response = new QuadraticEquationResponse();
        response.setD(20);
        response.setFormula("x^2 + 2x + 1 = 0");
        response.setX1(1.0);
        response.setX2(2.0);
        response.setError(null);
        return response;
    }

    public static QuadraticEquationResponse shapeSoapResponseWithError() {
        QuadraticEquationResponse response = new QuadraticEquationResponse();
        response.setD(20);
        response.setFormula("x^2 + 2x + 1 = 0");
        response.setX1(null);
        response.setX2(null);
        response.setError("Smth went wrong");
        return response;
    }
}
