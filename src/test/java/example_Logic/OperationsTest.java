package example_Logic;
import org.example_Logic.Operations;
import org.example_Model.Monomial;
import org.example_Model.Polynomial;
import org.junit.jupiter.api.Test;
import java.util.HashMap;
import java.util.Map;
import static org.junit.jupiter.api.Assertions.assertEquals;
public class OperationsTest {
    @Test
    public void addTest() {
        Map<Integer, Monomial> monomials1 = new HashMap<>();
        monomials1.put(3, new Monomial(2, 3)); // 2x^3
        Polynomial polynomial1 = new Polynomial(monomials1);
        Map<Integer, Monomial> monomials2 = new HashMap<>();
        monomials2.put(2, new Monomial(3, 2)); // 3x^2
        Polynomial polynomial2 = new Polynomial(monomials2);
        Map<Integer, Monomial> expectedMonomials = new HashMap<>();
        expectedMonomials.put(3, new Monomial(2, 3)); // 2x^3
        expectedMonomials.put(2, new Monomial(3, 2)); // 3x^2
        Polynomial expected = new Polynomial(expectedMonomials);
        Polynomial actual = Operations.add(polynomial1, polynomial2);
        assertEquals(expected.toString(), actual.toString());
    }
    @Test
    public void subtractTest() {
        Map<Integer, Monomial> monomials1 = new HashMap<>();
        monomials1.put(3, new Monomial(3, 2)); // 2x^3
        Polynomial polynomial1 = new Polynomial(monomials1);
        Map<Integer, Monomial> monomials2 = new HashMap<>();
        monomials2.put(2, new Monomial(2, 3)); // 3x^2
        Polynomial polynomial2 = new Polynomial(monomials2);
        Map<Integer, Monomial> expectedMonomials = new HashMap<>();
        expectedMonomials.put(3, new Monomial(3, 2));
        expectedMonomials.put(2, new Monomial(2, -3)); // (-3)x^2
        Polynomial expected = new Polynomial(expectedMonomials);
        Polynomial actual = Operations.subtract(polynomial1, polynomial2);
        assertEquals(expected.toString(), actual.toString());
    }
    @Test
    public void derivativeTest() {
        Map<Integer, Monomial> monomials = new HashMap<>();
        monomials.put(3, new Monomial(3, 2)); // 2x^3
        monomials.put(2, new Monomial(2, 3)); // 3x^2
        Polynomial polynomial = new Polynomial(monomials);
        Map<Integer, Monomial> expectedMonomials = new HashMap<>();
        expectedMonomials.put(2, new Monomial(2, 6)); // 6x^2
        expectedMonomials.put(1, new Monomial(1, 6)); // 6x
        Polynomial expected = new Polynomial(expectedMonomials);
        Polynomial actual = Operations.derivative(polynomial);
        assertEquals(expected.toString(), actual.toString());
    }
}