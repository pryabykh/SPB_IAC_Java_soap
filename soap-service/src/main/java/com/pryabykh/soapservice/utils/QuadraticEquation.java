package com.pryabykh.soapservice.utils;

import com.pryabykh.soapservice.dtos.X1X2Pair;
import com.pryabykh.soapservice.exceptions.ArgumentsCannotBeNullException;

public class QuadraticEquation {
    private final Integer a;
    private final Integer b;
    private final Integer c;

    public QuadraticEquation(Integer a, Integer b, Integer c) throws ArgumentsCannotBeNullException {
        if(a == null || b == null || c == null) {
            throw new ArgumentsCannotBeNullException();
        }
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public String getFormula() {
        String aArgument = a >= 0 ? String.valueOf(a) : "-" + Math.abs(a);
        aArgument = Math.abs(a) == 1 ? aArgument.replace("1", "") : aArgument;

        String bArgument = b >= 0 ? "+ " + b : "- " + Math.abs(b);
        bArgument = Math.abs(b) == 1 ? bArgument.replace("1", "") : bArgument;

        String cArgument = c >= 0 ? "+ " + c : "- " + Math.abs(c);
        return String.format("%sx^2 %sx %s = 0", aArgument , bArgument, cArgument);
    }

    public Integer getDiscriminant() {
        return (b * b) - (4 * a * c);
    }

    public X1X2Pair solve() {
        X1X2Pair x1X2Pair = new X1X2Pair();
        Integer discriminant = getDiscriminant();
        if (discriminant < 0) {
            return x1X2Pair;
        }
        if (discriminant == 0) {
            Double x1 = (-b + Math.sqrt(discriminant)) / (2 * a);
            x1X2Pair.setX1(x1);
            x1X2Pair.setX2(null);
            return x1X2Pair;
        }
        Double x1 = (-b + Math.sqrt(discriminant)) / (2 * a);
        Double x2 = (-b - Math.sqrt(discriminant)) / (2 * a);
        x1X2Pair.setX1(x1);
        x1X2Pair.setX2(x2);
        return x1X2Pair;
    }
}
