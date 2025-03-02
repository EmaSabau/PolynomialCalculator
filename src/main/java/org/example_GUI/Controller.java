package org.example_GUI;
import org.example_Logic.Operations;
import org.example_Model.Polynomial;
import org.example_Model.Monomial;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;

public class Controller implements ActionListener {
    private View view;
    private Operations operations = new Operations();
    public Controller(View v){
        this.view = v;
    }

    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();
        String firstNumber = view.getFirstNumberTextField().getText();
        String secondNumber = view.getSecondNumberTextField().getText();
        Polynomial firstPolynomial = parsePolynomial(firstNumber);
        Polynomial secondPolynomial = parsePolynomial(secondNumber);
        Polynomial resultPolynomial = null;
        switch(command) {
            case "Add":
                resultPolynomial = operations.add(firstPolynomial, secondPolynomial);
                break;
            case "Subtract":
                resultPolynomial = operations.subtract(firstPolynomial, secondPolynomial);
                break;
            case "Multiply" :
                resultPolynomial = operations.multiply(firstPolynomial, secondPolynomial);
                break;
            case "Derivative":
                resultPolynomial = operations.derivative(firstPolynomial);
                break;
            case "Integration":
                resultPolynomial = operations.integration(firstPolynomial);
                break;
            default:
            break;
        }
        resultPolynomial.sortMonomials();
        view.getResultValueLabel().setText(String.valueOf(resultPolynomial));
    }
    private Polynomial parsePolynomial(String polynomialText) {
        Map<Integer, Monomial> monomials = new HashMap<>();
        String[] terms = polynomialText.split("\\s+");
        for (String term : terms) {
            String[] parts = term.split("\\*x\\^");
            if (parts.length != 2) {
                continue;
            }
            int coefficient = Integer.parseInt(parts[0].trim());
            int degree = Integer.parseInt(parts[1].trim());
            monomials.put(degree, new Monomial(degree, coefficient));

        }
        return new Polynomial(monomials);
    }
}