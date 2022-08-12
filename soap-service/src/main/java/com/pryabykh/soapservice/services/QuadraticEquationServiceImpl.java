package com.pryabykh.soapservice.services;

import com.pryabykh.soapservice.dtos.X1X2Pair;
import com.pryabykh.soapservice.exceptions.ArgumentsCannotBeNullException;
import com.pryabykh.soapservice.utils.QuadraticEquation;
import com.pryabykh.xml.equation.QuadraticEquationResponse;
import org.springframework.stereotype.Service;

@Service
public class QuadraticEquationServiceImpl implements QuadraticEquationService {
    @Override
    public QuadraticEquationResponse solve(Integer a, Integer b, Integer c) {
        QuadraticEquationResponse response = new QuadraticEquationResponse();
        QuadraticEquation quadraticEquation;
        try {
            quadraticEquation = new QuadraticEquation(a, b, c);
        } catch (ArgumentsCannotBeNullException e) {
            response.setError("All arguments are required");
            return response;
        }
        response.setFormula(quadraticEquation.getFormula());
        response.setD(quadraticEquation.getDiscriminant());
        if (quadraticEquation.getDiscriminant() < 0) {
            response.setError("Discriminant less then 0");
            return response;
        }
        X1X2Pair x1X2Pair = quadraticEquation.solve();
        response.setX1(x1X2Pair.getX1());
        response.setX2(x1X2Pair.getX2());
        return response;
    }
}
