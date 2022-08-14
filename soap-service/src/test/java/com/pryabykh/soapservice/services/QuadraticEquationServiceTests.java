package com.pryabykh.soapservice.services;

import com.pryabykh.xml.equation.QuadraticEquationResponse;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class QuadraticEquationServiceTests {
    private QuadraticEquationService quadraticEquationService;

    @Test
    public void solvePositiveTwoRoots() {
        QuadraticEquationResponse solution = quadraticEquationService.solve(1, -4, -5);
        Assertions.assertEquals(36, solution.getD());
        Assertions.assertEquals(5, solution.getX1());
        Assertions.assertEquals(-1, solution.getX2());
        Assertions.assertEquals("x^2 - 4x - 5 = 0", solution.getFormula());
        Assertions.assertNull(solution.getError());
    }

    @Test
    public void solvePositiveTwOneRoot() {
        QuadraticEquationResponse solution = quadraticEquationService.solve(1, -6, 9);
        Assertions.assertEquals(0, solution.getD());
        Assertions.assertEquals(3, solution.getX1());
        Assertions.assertNull(solution.getX2());
        Assertions.assertEquals("x^2 - 6x + 9 = 0", solution.getFormula());
        Assertions.assertNull(solution.getError());
    }

    @Test
    public void solveNoRoots() {
        QuadraticEquationResponse solution = quadraticEquationService.solve(3, -4, 2);
        Assertions.assertEquals(-8, solution.getD());
        Assertions.assertNull(solution.getX1());
        Assertions.assertNull(solution.getX2());
        Assertions.assertEquals("3x^2 - 4x + 2 = 0", solution.getFormula());
        Assertions.assertNotNull(solution.getError());
    }

    @Test
    public void solveNullArguments() {
        QuadraticEquationResponse solution = quadraticEquationService.solve(null, null, null);
        Assertions.assertNull(solution.getD());
        Assertions.assertNull(solution.getX1());
        Assertions.assertNull(solution.getX2());
        Assertions.assertNull(solution.getFormula());
        Assertions.assertNotNull(solution.getError());
    }

    @Autowired
    public void setQuadraticEquationService(QuadraticEquationService quadraticEquationService) {
        this.quadraticEquationService = quadraticEquationService;
    }
}
