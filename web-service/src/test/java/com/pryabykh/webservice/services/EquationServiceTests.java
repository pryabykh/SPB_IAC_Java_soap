package com.pryabykh.webservice.services;

import com.pryabykh.webservice.TestUtils;
import com.pryabykh.webservice.dtos.SolutionDto;
import com.pryabykh.webservice.soapclient.SOAPConnector;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import javax.validation.ConstraintViolationException;

@SpringBootTest
public class EquationServiceTests {
    private EquationService equationService;
    @MockBean
    private SOAPConnector soapConnector;

    @Test
    public void solvePositive() {
        Mockito.when(soapConnector.callWebService(Mockito.anyString(), Mockito.any()))
                .thenReturn(TestUtils.shapeSoapResponse());
        SolutionDto solutionDto = equationService.solve(1, 2, 3);
        Assertions.assertNotNull(solutionDto.getD());
        Assertions.assertNotNull(solutionDto.getFormula());
        Assertions.assertNotNull(solutionDto.getX1());
        Assertions.assertNotNull(solutionDto.getX2());
        Assertions.assertNull(solutionDto.getError());
    }

    @Test
    public void solveWithError() {
        Mockito.when(soapConnector.callWebService(Mockito.anyString(), Mockito.any()))
                .thenReturn(TestUtils.shapeSoapResponseWithError());
        SolutionDto solutionDto = equationService.solve(1, 2, 3);
        Assertions.assertNotNull(solutionDto.getD());
        Assertions.assertNotNull(solutionDto.getFormula());
        Assertions.assertNull(solutionDto.getX1());
        Assertions.assertNull(solutionDto.getX2());
        Assertions.assertNotNull(solutionDto.getError());
    }

    @Test
    public void solveThrowsConstraintViolationException() {
        Assertions.assertThrows(ConstraintViolationException.class, () ->
                equationService.solve(null, null, null));
    }

    @Autowired
    public void setEquationService(EquationService equationService) {
        this.equationService = equationService;
    }
}
