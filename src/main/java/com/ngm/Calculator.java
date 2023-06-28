package com.ngm;

public class Calculator {
    public int add(int a, int b) {
        return a + b;
    }

    public int subtract(int a, int b) {
        return a - b;
    }

    public double somefn(double val) {
        if (val == 0) {
            throw new IllegalArgumentException("val cannot be 0");
            // return 0;
        }
        return val;
    }
}
