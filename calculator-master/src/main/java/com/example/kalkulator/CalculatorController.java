package com.example.kalkulator;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.text.Text;

public class CalculatorController {
    @FXML
    public TextField textFieldA;
    @FXML
    public TextField textFieldB;
    @FXML
    public TextField textFieldC;
    @FXML
    public Text textDelta;
    @FXML
    public Text textx1;
    @FXML
    public Text textx2;
    @FXML
    private TextField textField;

    @FXML
    private Text savedNumbers;

    private String firstNumber = "";

    private String currentNumber = "";

    private String calculationType;

    public void calculationSetup(String calculationType){
        this.calculationType = calculationType;
        firstNumber = currentNumber;
        currentNumber = "";
        savedNumbers.setText(firstNumber + " " + calculationType);
    }

    public void updateTextField(){
        textField.setText(currentNumber);
    }

    public void addNumber(String number){
        currentNumber += number;
        updateTextField();
    }

    @FXML
    void addAction(ActionEvent event) {
        calculationSetup("+");
    }

    @FXML
    void minusAction(ActionEvent event) {
        calculationSetup("-");
    }

    @FXML
    void divideAction(ActionEvent event) {
        calculationSetup("/");
    }

    @FXML
    void multiplicationAction(ActionEvent event) {
        calculationSetup("*");
    }

    @FXML
    void calculate(ActionEvent event) {
        double firstNumberInt = Double.parseDouble(firstNumber);
        double secondNumberInt = Double.parseDouble(currentNumber);
        double calculatedNumber = 0;
        switch (calculationType) {
            case "+" -> {
                calculatedNumber = firstNumberInt + secondNumberInt;
                savedNumbers.setText(firstNumber + " + " + currentNumber + " = " + calculatedNumber);
            }
            case "-" -> {
                calculatedNumber = firstNumberInt - secondNumberInt;
                savedNumbers.setText(firstNumber + " - " + currentNumber + " = " + calculatedNumber);
            }
            case "/" -> {
                calculatedNumber = firstNumberInt / secondNumberInt;
                savedNumbers.setText(firstNumber + " / " + currentNumber + " = " + calculatedNumber);
            }
            case "*" -> {
                calculatedNumber = firstNumberInt * secondNumberInt;
                savedNumbers.setText(firstNumber + " * " + currentNumber + " = " + calculatedNumber);
            }
        }
        int casted = (int)calculatedNumber;
        if (casted == calculatedNumber) {
            textField.setText(String.valueOf(casted));
        } else {
            textField.setText(String.valueOf(calculatedNumber));
        }

        currentNumber = String.valueOf(calculatedNumber);
    }

    @FXML
    void clearTextField(ActionEvent event) {
        currentNumber = "";
        textField.setText("");
        savedNumbers.setText("");
    }

    @FXML
    void button0Clicked(ActionEvent event) {
        if(!currentNumber.equals("")){
            addNumber("0");
        }
    }

    @FXML
    void button1Clicked(ActionEvent event) {
        addNumber("1");
    }

    @FXML
    void button2Clicked(ActionEvent event) {
        addNumber("2");
    }

    @FXML
    void button3Clicked(ActionEvent event) {
        addNumber("3");
    }

    @FXML
    void button4Clicked(ActionEvent event) {
        addNumber("4");
    }

    @FXML
    void button5Clicked(ActionEvent event) {
        addNumber("5");
    }

    @FXML
    void button6Clicked(ActionEvent event) {
        addNumber("6");
    }

    @FXML
    void button7Clicked(ActionEvent event) {
        addNumber("7");
    }

    @FXML
    void button8Clicked(ActionEvent event) {
        addNumber("8");
    }

    @FXML
    void button9Clicked(ActionEvent event) {
        addNumber("9");
    }


    @FXML
    public void squareFunctionCalculation(KeyEvent actionEvent) {
        textx1.setText("x1: ");
        textx2.setText("x2: ");
        textDelta.setText("Delta: ");

        if (textFieldA.getText().equals("") || textFieldB.getText().equals("") || textFieldC.getText().equals("")) {
            return;
        }

        double a, b, c;
        try {
             a = Double.parseDouble(textFieldA.getText());
             b = Double.parseDouble(textFieldB.getText());
             c = Double.parseDouble(textFieldC.getText());
        } catch (NumberFormatException e) {
            // nie cyfra
            return;
        }

        double delta = Math.pow(b, 2) - 4 * a * c;
        textDelta.setText("Delta: " + delta);
        if (delta < 0) {
            return;
        }
        double x1 = (-b - Math.sqrt(delta)) / 2 * a;
        double x2 = (-b + Math.sqrt(delta)) / 2 * a;

        textx1.setText("x1: " + x1);
        textx2.setText("x2: " + x2);
    }
}