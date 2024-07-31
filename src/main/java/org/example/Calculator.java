package org.example;

public class Calculator {

    public int factorial(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("The number must be non-negative.");
        }
        int result = 1;
        for (int i = 1; i <= n; i++) {
            result *= i;
        }
        return result;
    }

    public int binomialCoefficient(int n, int k) {
        if (n < 0 || k < 0) {
            throw new IllegalArgumentException("Must be non-negative.");
        }
        if (k > n) {
            throw new IllegalArgumentException("Cannot exceed set size.");
        }
        return factorial(n) / (factorial(k) * factorial(n - k));
    }

    // A helper method for calculating factorial in the binomialCoefficient method
    private int factorialHelper(int n) {
        int result = 1;
        for (int i = 1; i <= n; i++) {
            result *= i;
        }
        return result;
    }
}

