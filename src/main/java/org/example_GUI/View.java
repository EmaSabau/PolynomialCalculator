package org.example_GUI;
import javax.swing.*;
import java.awt.*;
public class View extends JFrame {
    private JPanel contentPane;
    private JPanel numbersPanel;
    private JPanel operationsPanel;
    private JButton addButton;
    private JButton subtractButton;
    private JButton multiplyButton;
    private JButton divideButton;
    private JButton derivativeButton;
    private JButton integrationButton;
    private JTextField firstNumberTextField;
    private JTextField secondNumberTextField;
    private JLabel resultLabel;
    private JLabel resultValueLabel;
    private Controller controller;
    public View(String name) {
        super(name);
        controller = new Controller(this);
        prepareGui();
    }
    public void prepareGui() {
        setSize(500, 300);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        contentPane = new JPanel(new BorderLayout());
        contentPane.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        prepareNumbersPanel();
        prepareOperationsPanel();
        prepareResultPanel();
        setContentPane(contentPane);
        setVisible(true);
    }
    private void prepareNumbersPanel() {
        numbersPanel = new JPanel(new GridLayout(2, 2, 5, 5));
        numbersPanel.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        JLabel firstNumberLabel = new JLabel("First number:", JLabel.RIGHT);
        numbersPanel.add(firstNumberLabel);
        firstNumberTextField = new JTextField();
        numbersPanel.add(firstNumberTextField);
        JLabel secondNumberLabel = new JLabel("Second number:", JLabel.RIGHT);
        numbersPanel.add(secondNumberLabel);
        secondNumberTextField = new JTextField();
        numbersPanel.add(secondNumberTextField);
        contentPane.add(numbersPanel, BorderLayout.NORTH);
    }
    private void prepareOperationsPanel() {
        operationsPanel = new JPanel(new GridLayout(3, 2, 5, 5));
        operationsPanel.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        addButton = new JButton("Add");
        addButton.addActionListener(controller);
        operationsPanel.add(addButton);
        subtractButton = new JButton("Subtract");
        subtractButton.addActionListener(controller);
        operationsPanel.add(subtractButton);
        multiplyButton = new JButton("Multiply");
        multiplyButton.addActionListener(controller);
        operationsPanel.add(multiplyButton);
        divideButton = new JButton("Divide");
        divideButton.addActionListener(controller);
        operationsPanel.add(divideButton);
        derivativeButton = new JButton("Derivative");
        derivativeButton.addActionListener(controller);
        operationsPanel.add(derivativeButton);
        integrationButton = new JButton("Integration");
        integrationButton.addActionListener(controller);
        operationsPanel.add(integrationButton);
        contentPane.add(operationsPanel, BorderLayout.CENTER);
    }
    private void prepareResultPanel() {
        JPanel resultPanel = new JPanel(new GridLayout(1, 2, 5, 5));
        resultPanel.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        resultLabel = new JLabel("Result:", JLabel.RIGHT);
        resultPanel.add(resultLabel);
        resultValueLabel = new JLabel("", JLabel.LEFT);
        resultPanel.add(resultValueLabel);
        contentPane.add(resultPanel, BorderLayout.SOUTH);
    }
    public JTextField getFirstNumberTextField() {
        return firstNumberTextField;
    }
    public JTextField getSecondNumberTextField() {
        return secondNumberTextField;
    }

    public JLabel getResultValueLabel() {
        return resultValueLabel;
    }
}