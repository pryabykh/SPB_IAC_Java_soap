package com.pryabykh.webservice.controllers;

import com.pryabykh.webservice.TestUtils;
import com.pryabykh.webservice.services.EquationService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import javax.validation.ConstraintViolationException;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(EquationController.class)
public class EquationControllerTests {
    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private EquationService equationService;

    @Test
    public void solvePositive() throws Exception {
        Mockito.when(equationService.solve(Mockito.anyInt(), Mockito.anyInt(), Mockito.anyInt()))
                .thenReturn(TestUtils.shapeSolutionDto());
        mockMvc.perform(get("/api/calc/?a=1&b=2&c=3"))
                .andExpect(status().isOk());
    }

    @Test
    public void solveInvalidRequest() throws Exception {
        Mockito.when(equationService.solve(Mockito.anyInt(), Mockito.anyInt(), Mockito.anyInt()))
                .thenThrow(ConstraintViolationException.class);
        mockMvc.perform(get("/api/calc/?a=1&b=2&c=3"))
                .andExpect(status().isBadRequest());
    }

    @Test
    public void solveInternalServerError() throws Exception {
        Mockito.when(equationService.solve(Mockito.anyInt(), Mockito.anyInt(), Mockito.anyInt()))
                .thenThrow(RuntimeException.class);
        mockMvc.perform(get("/api/calc/?a=1&b=2&c=3"))
                .andExpect(status().isInternalServerError());
    }
}
