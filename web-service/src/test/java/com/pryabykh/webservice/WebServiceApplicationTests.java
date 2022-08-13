package com.pryabykh.webservice;

import com.pryabykh.webservice.schemas.equation.QuadraticEquationRequest;
import com.pryabykh.webservice.schemas.equation.QuadraticEquationResponse;
import com.pryabykh.webservice.soapclient.SOAPConnector;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class WebServiceApplicationTests {
    @Autowired
    private SOAPConnector soapConnector;

    @Test
    void contextLoads() {
        QuadraticEquationRequest request = new QuadraticEquationRequest();
        request.setA(1);
        request.setB(-4);
        request.setC(-5);

        QuadraticEquationResponse response = (QuadraticEquationResponse) soapConnector.callWebService(
                "http://localhost:8080/service/equation",
                request
        );

        System.out.println("x1: " + response.getX1());
        System.out.println("x2: " + response.getX2());
        System.out.println("D: " + response.getD());
        System.out.println(response.getFormula());
    }

}
