package org.example_Model;
import java.util.*;
public class Polynomial {
    private Map<Integer, Monomial> monomials;
    public Polynomial() {
        this.monomials = new HashMap<>();
    }
    public Polynomial(Map<Integer, Monomial> monomials) {
        if (monomials != null) {
            this.monomials = monomials;
        } else {
            this.monomials = new HashMap<>();
        }
    }
    public Map<Integer, Monomial> getMonomials() {
        return monomials;
    }
    public void setMonomials(Map<Integer, Monomial> monomials) {
        this.monomials = monomials;
    }
    public void addMonomial(Monomial monomial)
    {
        int degree = monomial.getDegree();
        if (monomials.containsKey(degree)) {
            Monomial existingMonomial = monomials.get(degree);
            existingMonomial.setCoefficient(existingMonomial.getCoefficient().doubleValue() + monomial.getCoefficient().doubleValue());
        } else {
            monomials.put(degree, monomial);
        }
    }
    public void sortMonomials() {
        Comparator<Integer> reverseComparator = Comparator.reverseOrder();
        TreeMap<Integer, Monomial> sortedMonomials = new TreeMap<>(reverseComparator);
        sortedMonomials.putAll(monomials);
        monomials = sortedMonomials;
    }
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Polynomial other = (Polynomial) obj;
        return Objects.equals(this.monomials, other.monomials);
    }
    public String toString() {
        StringBuilder sb = new StringBuilder();
        boolean isFirstTerm = true;
        for (Map.Entry<Integer, Monomial> entry : monomials.entrySet()) {
            int degree = entry.getKey();
            Monomial monomial = entry.getValue();
            int coefficient = monomial.getCoefficient().intValue();
            if (coefficient == 0) {
                continue;
            }
            if (coefficient > 0 && !isFirstTerm) {
                sb.append(" + ");
            }
            if (degree == 0) {
                sb.append(coefficient);
            } else if (degree == 1) {
                sb.append(coefficient).append("x");
            } else {
                sb.append(coefficient).append("x^").append(degree);
            }
            isFirstTerm = false;
        }
        if (sb.length() == 0) {
            sb.append("0");
        }
        return sb.toString();
    }
    public boolean containsKey(Integer key) {
        if (monomials == null) {
            return false;
        }
        return monomials.containsKey(key);
    }
}