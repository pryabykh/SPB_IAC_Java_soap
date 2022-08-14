package com.pryabykh.webservice.services;

import com.pryabykh.webservice.dtos.SolutionDto;
import com.pryabykh.webservice.schemas.equation.QuadraticEquationRequest;
import com.pryabykh.webservice.schemas.equation.QuadraticEquationResponse;
import com.pryabykh.webservice.soapclient.SOAPConnector;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class EquationServiceImpl implements EquationService {
    private final SOAPConnector soapConnector;
    @Value("${soap.service.host}")
    private String soapServiceHost;

    public EquationServiceImpl(SOAPConnector soapConnector) {
        this.soapConnector = soapConnector;
    }

    @Override
    public SolutionDto solve(Integer a, Integer b, Integer c) {
        QuadraticEquationRequest request = new QuadraticEquationRequest();
        request.setA(a);
        request.setB(b);
        request.setC(c);

        QuadraticEquationResponse response = (QuadraticEquationResponse) soapConnector.callWebService(
                soapServiceHost + "/service/equation",
                request
        );

        SolutionDto solution = new SolutionDto();
        solution.setError(response.getError());
        solution.setX1(response.getX1());
        solution.setX2(response.getX2());
        solution.setD(response.getD());
        solution.setFormula(response.getFormula());
        return solution;
    }
}
