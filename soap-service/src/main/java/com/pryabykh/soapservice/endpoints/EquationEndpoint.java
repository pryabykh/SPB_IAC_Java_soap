package com.pryabykh.soapservice.endpoints;

import com.pryabykh.soapservice.services.QuadraticEquationService;
import com.pryabykh.xml.equation.QuadraticEquationRequest;
import com.pryabykh.xml.equation.QuadraticEquationResponse;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

@Endpoint
public class EquationEndpoint {
    private final QuadraticEquationService quadraticEquationService;
    private static final String NAMESPACE_URI = "http://pryabykh.com/xml/equation";

    public EquationEndpoint(QuadraticEquationService quadraticEquationService) {
        this.quadraticEquationService = quadraticEquationService;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "QuadraticEquationRequest")
    @ResponsePayload
    public QuadraticEquationResponse solveEquation(@RequestPayload QuadraticEquationRequest request) {
        return quadraticEquationService.solve(request.getA(), request.getB(), request.getC());
    }
}
