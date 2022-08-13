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
    }

}
