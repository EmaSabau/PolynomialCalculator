package org.example_Logic;
import org.example_Model.Polynomial;
import org.example_Model.Monomial;
import java.util.HashMap;
import java.util.Map;
public class Operations {
    public static Polynomial add(Polynomial polynomial1, Polynomial polynomial2) {
        Map<Integer, Monomial> resultMonomials = new HashMap<>();
        polynomial1.getMonomials().forEach((degree, monomial) -> {
            resultMonomials.put(degree, new Monomial(monomial.getDegree(), monomial.getCoefficient()));
        });
        polynomial2.getMonomials().forEach((degree, monomial) -> {
            Monomial existingMonomial = resultMonomials.getOrDefault(degree, new Monomial(0, 0.0));
            existingMonomial.setCoefficient(existingMonomial.getCoefficient().doubleValue() + monomial.getCoefficient().doubleValue());
            resultMonomials.put(degree, existingMonomial);
        });
        return new Polynomial(resultMonomials);
    }
    public static Polynomial subtract(Polynomial polynomial1, Polynomial polynomial2) {
        Map<Integer, Monomial> resultMonomials = new HashMap<>();
        polynomial1.getMonomials().forEach((degree, monomial) -> {
            resultMonomials.put(degree, new Monomial(monomial.getDegree(), monomial.getCoefficient()));
        });
        polynomial2.getMonomials().forEach((degree, monomial) -> {
            Monomial existingMonomial = resultMonomials.getOrDefault(degree, new Monomial(0, 0.0));
            existingMonomial.setCoefficient(existingMonomial.getCoefficient().doubleValue() - monomial.getCoefficient().doubleValue());
            resultMonomials.put(degree, existingMonomial);
        });
        return new Polynomial(resultMonomials);
    }
    public static Polynomial multiply(Polynomial polynomial1, Polynomial polynomial2) {
        Map<Integer, Monomial> resultMonomials = new HashMap<>();
        polynomial1.getMonomials().forEach((degree, monomial) -> resultMonomials.put(degree, new Monomial(monomial.getDegree(), 0)));
        polynomial1.getMonomials().forEach((degree1, monomial1) -> {
            polynomial2.getMonomials().forEach((degree2, monomial2) -> {
                int resultDegree = degree1 + degree2;
                double resultCoefficient = monomial1.getCoefficient().doubleValue() * monomial2.getCoefficient().doubleValue();
                if (resultMonomials.containsKey(resultDegree)) {
                    Monomial existingMonomial = resultMonomials.get(resultDegree);
                    existingMonomial.setCoefficient(existingMonomial.getCoefficient().doubleValue() + resultCoefficient);
                } else {
                    resultMonomials.put(resultDegree, new Monomial(resultDegree, resultCoefficient));
                }
            });
        });
        return new Polynomial(resultMonomials);
    }
    public static Polynomial derivative(Polynomial polynomial) {
        Map<Integer, Monomial> resultMonomials = new HashMap<>();
        polynomial.getMonomials().forEach((degree, monomial) -> {
            if (degree > 0) {
                resultMonomials.put(degree - 1, new Monomial(degree - 1, monomial.getCoefficient().doubleValue() * degree));
            }
        });
        return new Polynomial(resultMonomials);
    }
    public static Polynomial integration(Polynomial polynomial) {
        Map<Integer, Monomial> resultMonomials = new HashMap<>();
        polynomial.getMonomials().forEach((degree, monomial) ->
                resultMonomials.put(degree + 1, new Monomial(degree + 1, monomial.getCoefficient().doubleValue() / (degree + 1))));
        resultMonomials.put(0, new Monomial(0, 0));
        return new Polynomial(resultMonomials);
    }
}