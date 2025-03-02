# **Table of Contents**  
1. [**Project Objective**](#project-objective)  
2. [**Problem Analysis, Modeling, Scenarios, and Use Cases**](#problem-analysis-modeling-scenarios-and-use-cases)  
   - 2.1. [**Functional Requirements**](#functional-requirements)  
   - 2.2. [**Use Cases**](#use-cases)  
3. [**Design**](#design)  
4. [**Implementation**](#implementation)  
   - 4.1. [**Main Classes**](#main-classes)  
   - 4.2. [**User Interface**](#user-interface)  
5. [**Results**](#results)  
   - 5.1. [**Test Scenarios**](#test-scenarios)  
   - 5.2. [**JUnit Results**](#junit-results)  
6. [**Conclusions**](#conclusions)  
7. [**Bibliography**](#bibliography)  

---

## **Project Objective**  
The objective of this project is to develop a **polynomial calculator** that can perform various operations on polynomials.  

To achieve this:  
- A **graphical user interface (GUI)** has been implemented for user interaction.  
- Operations such as **addition, subtraction, multiplication, differentiation, and integration** have been defined.  
- **HashMaps** have been used for easier polynomial manipulation.  

---

## **Problem Analysis, Modeling, Scenarios, and Use Cases**  

### **Functional Requirements**  
- The user can input **two polynomials** in the format `coefficient*x^exponent`.  
- The user selects the desired operation: **addition, subtraction, multiplication, division, differentiation, or integration**.  
- The result is displayed in the **graphical interface**.  

### **Use Cases**  
- **Addition of polynomials:**  
  - The user enters two polynomials.  
  - The "ADD" button is pressed.  

- **Subtraction of polynomials:**  
  - The user enters two polynomials.  
  - The "SUBTRACT" button is pressed.  

- **Multiplication of polynomials:**  
  - The user enters two polynomials.  
  - The "MULTIPLY" button is pressed.  

- **Differentiation of a polynomial:**  
  - The user enters the coefficients and exponents of the polynomial to be differentiated.  
  - The "DERIVATIVE" button is pressed.  

- **Integration of a polynomial:**  
  - The user enters the coefficients and exponents of the polynomial to be integrated.  
  - The "INTEGRATION" button is pressed.  

For differentiation and integration, the polynomial entered in the **first text box** is considered.  

---

## **Design**  
The graphical user interface allows users to input polynomials through text fields.  

In the example below, the sum of two polynomials is computed after pressing the "Add" button.  

The project includes two main classes:  
- **Monomial** and **Polynomial**  
- The **Polynomial** class contains a `HashMap` of monomials and the `addMonomials` method for polynomial creation.  

Operations on polynomials are implemented in a separate **Operations** class. When a button is pressed, the corresponding polynomial operation is executed.  

---

## **Implementation**  

### **Main Classes**  
- **Polynomial**: Uses a `HashMap` to store monomials.  
- **Monomial**: Represents a single term with its coefficient and exponent.  
- **Operations**: Contains methods to perform polynomial operations.  

### **User Interface**  
The user interface allows polynomial input and operation selection.  

The following classes handle the UI:  
- **View**: Defines the layout (buttons, text fields).  
- **Controller**: Implements methods like `actionPerformed`, ensuring each UI element functions properly.  
  - Example: Pressing the **"Integration"** button triggers polynomial integration.  

---

## **Results**  

### **Test Scenarios**  
- **Addition**  
- **Subtraction**  
- **Multiplication**  
  
For these operations, two polynomials must be provided. If one is missing, it is considered **zero**.  
  
- **Differentiation**  
- **Integration**  
  
For these operations, only the polynomial in the **first text field** is considered.  

### **JUnit Results**  
Unit tests using **JUnit** validate the correctness of the polynomial operations.  

By implementing and testing these functionalities, the project demonstrates an accurate and efficient **polynomial calculator**.  

---

## **Conclusions**  
A **graphical polynomial calculator** was successfully implemented, providing an intuitive and efficient way to perform polynomial operations.  

Future improvements could include:  
- A **more visually appealing interface**.  
- Improved polynomial input format (e.g., allowing `6x` instead of `6x^1`).  
- Adding **division** functionality.  
- Expanding operations beyond polynomials to other mathematical objects.  

---

## **Bibliography**  
- What are Java classes? - [http://www.tutorialspoint.com](http://www.tutorialspoint.com)  
- **Fundamental Programming Techniques** - [https://dsrl.eu/courses/pt/](https://dsrl.eu/courses/pt/)  
- **Java Swing Examples** - [https://gitlab.com/dsrl-pt/pt-gui-demo-swing](https://gitlab.com/dsrl-pt/pt-gui-demo-swing)  
- **JUnit 5 User Guide** - [https://junit.org/junit5/docs/current/user-guide/](https://junit.org/junit5/docs/current/user-guide/)  
- **Parameterized Tests in JUnit 5** - [https://www.baeldung.com/parameterized-tests-junit-5](https://www.baeldung.com/parameterized-tests-junit-5)  
- **Polynomial Parser** - [https://stackoverflow.com/questions/26883037/polynomial-string-not-split](https://stackoverflow.com/questions/26883037/polynomial-string-not-split)
