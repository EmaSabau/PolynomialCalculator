package org.example_Model;

public class Monomial {
    private int degree;
    private Number coefficient;
    public Monomial(int degree, Number coefficient) {
        this.degree = degree;
        this.coefficient = coefficient;
    }
    public int getDegree() {
        return degree;
    }
    public void setDegree(int degree) {
        this.degree = degree;
    }
    public Number getCoefficient() {
        return coefficient;
    }
    public void setCoefficient(Number coefficient) {
        this.coefficient = coefficient;
    }
    public String toString() {
        if (coefficient.intValue() == 0) {
            return "0";
        } else if (coefficient.intValue() == 1) {
            return "x^" + degree;
        } else if (coefficient.intValue() == -1) {
            return "-x^" + degree;
        } else {
            if (coefficient.intValue() % 1 == 0) {
                return (int) coefficient .intValue()+ "x^" + degree;
            } else {
                return coefficient.intValue() + "x^" + degree;
            }
        }
    }

}