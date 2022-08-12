package com.pryabykh.soapservice.services;

import com.pryabykh.xml.equation.QuadraticEquationResponse;

public interface QuadraticEquationService {
    QuadraticEquationResponse solve(Integer a, Integer b, Integer c);
}
