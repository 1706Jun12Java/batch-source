package com.company.Q15;

public class Example implements MathMethods {


    @Override
    public double addition(double a, double b) {
        return a+b;
    }

    @Override
    public double subtraction(double a, double b) {
        return a - b;
    }

    @Override
    public double multiplication(double a, double b) {
        return a * b;
    }

    @Override
    public double division(double a, double b) {
        return a / b;
    }
}
