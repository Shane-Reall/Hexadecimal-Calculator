/**
 * This is a simple java program that can take 2 numbers in Hexadecimal notion and either add, subtract, multiple, or divide them with each other.
 */

package com.example.hexadecimalcalulator;

//Imports
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;

public class Calculator extends Application {

    boolean operator = false; //Tracks the current amount of operator in the equation to avoid any complex equations from being entered

    @Override
    public void start(Stage stage) throws IOException {
        //Creation of all the elements for the GUI
        TextField text = new TextField();
        Button zero = new Button("0");
        Button one = new Button("1");
        Button two = new Button("2");
        Button three = new Button("3");
        Button four = new Button("4");
        Button five = new Button("5");
        Button six = new Button("6");
        Button seven = new Button("7");
        Button eight = new Button("8");
        Button nine = new Button("9");
        Button a = new Button("A");
        Button b = new Button("B");
        Button c = new Button("C");
        Button d = new Button("D");
        Button ee = new Button("E");
        Button f = new Button("F");
        Button clear = new Button("Clear");
        Button enter = new Button("Enter");
        Button add = new Button("+");
        Button subtract = new Button("-");
        Button multiply = new Button("*");
        Button divide = new Button("/");
        int scale = 75;

        GridPane calcLayout = new GridPane();

        text.setEditable(false);

        //Setting the sizes of all the buttons to filled the space available on the calculator screen
        zero.setMinWidth(scale);
        one.setMinWidth(scale);
        two.setMinWidth(scale);
        three.setMinWidth(scale);
        four.setMinWidth(scale);
        five.setMinWidth(scale);
        six.setMinWidth(scale);
        seven.setMinWidth(scale);
        eight.setMinWidth(scale);
        nine.setMinWidth(scale);
        a.setMinWidth(scale);
        b.setMinWidth(scale);
        c.setMinWidth(scale);
        d.setMinWidth(scale);
        ee.setMinWidth(scale);
        f.setMinWidth(scale);
        clear.setMinWidth(scale);
        enter.setMinWidth(scale);
        add.setMinWidth(scale);
        subtract.setMinWidth(scale);
        multiply.setMinWidth(scale);
        divide.setMinWidth(scale);

        //Adds action to the buttons
        zero.setOnAction(e -> actionAdd(text, '0'));
        one.setOnAction(e -> actionAdd(text, '1'));
        two.setOnAction(e -> actionAdd(text, '2'));
        three.setOnAction(e -> actionAdd(text, '3'));
        four.setOnAction(e -> actionAdd(text, '4'));
        five.setOnAction(e -> actionAdd(text, '5'));
        six.setOnAction(e -> actionAdd(text, '6'));
        seven.setOnAction(e -> actionAdd(text, '7'));
        eight.setOnAction(e -> actionAdd(text, '8'));
        nine.setOnAction(e -> actionAdd(text, '9'));
        a.setOnAction(e -> actionAdd(text, 'A'));
        b.setOnAction(e -> actionAdd(text, 'B'));
        c.setOnAction(e -> actionAdd(text, 'C'));
        d.setOnAction(e -> actionAdd(text, 'D'));
        ee.setOnAction(e -> actionAdd(text, 'E'));
        f.setOnAction(e -> actionAdd(text, 'F'));
        add.setOnAction(e -> actionAdd(text, '+'));
        subtract.setOnAction(e -> actionAdd(text, '-'));
        multiply.setOnAction(e -> actionAdd(text, '*'));
        divide.setOnAction(e -> actionAdd(text, '/'));
        clear.setOnAction(e -> actionClear(text));
        enter.setOnAction(e -> actionCalculate(text));

        //Adds the buttons to the Gridpane
        calcLayout.add(zero, 0, 0);
        calcLayout.add(one, 1, 0);
        calcLayout.add(two, 2, 0);
        calcLayout.add(three, 3, 0);
        calcLayout.add(four, 4, 0);
        calcLayout.add(five, 0, 1);
        calcLayout.add(six, 1, 1);
        calcLayout.add(seven, 2, 1);
        calcLayout.add(eight, 3, 1);
        calcLayout.add(nine, 4, 1);
        calcLayout.add(a, 0, 2);
        calcLayout.add(b, 1, 2);
        calcLayout.add(c, 2, 2);
        calcLayout.add(d, 3, 2);
        calcLayout.add(ee, 4, 2);
        calcLayout.add(f, 0, 3);
        calcLayout.add(add, 1, 3);
        calcLayout.add(subtract, 2, 3);
        calcLayout.add(multiply, 3, 3);
        calcLayout.add(divide, 4, 3);
        calcLayout.add(clear, 3, 4);
        calcLayout.add(enter, 4, 4);
        calcLayout.setAlignment(Pos.CENTER);

        //Adding the gridpane to the the GUI via a VBox
        VBox vBox = new VBox(15 ,text ,calcLayout);
        vBox.setAlignment(Pos.CENTER);
        Scene HexScreen = new Scene(vBox, 320, 240);

        //Basic window setting
        stage.setTitle("Hexadecimal Calculator");
        stage.setScene(HexScreen);
        stage.setHeight(250);
        stage.setWidth(400);
        stage.setResizable(false);
        stage.show();
    }

    public void actionAdd(TextField text, char number) {
        if (!operator) {
            text.appendText(String.valueOf(number));
            if (number == '+' || number == '-' || number == '*' || number == '/') {
                operator = true;
            }
        } else if (number != '+' && number != '-' && number != '*' && number != '/') {
            text.appendText(String.valueOf(number));
        }
    }

    public void actionClear(TextField text) {
        text.clear();
        operator = false;
    }

    public void actionCalculate(TextField text) {
        StringBuilder equation = new StringBuilder(text.getText());

        if (equation.indexOf("+")!=-1 || equation.indexOf("-")!=-1 || equation.indexOf("*")!=-1 || equation.indexOf("/")!=-1) {
            int start;

            if (equation.indexOf("+")!=-1) {
                start = hexToTen(equation.substring(0, equation.indexOf("+"))) + hexToTen(equation.substring(equation.indexOf("+")+1));
            } else if (equation.indexOf("-")!=-1) {
                start = hexToTen(equation.substring(0, equation.indexOf("-"))) - hexToTen(equation.substring(equation.indexOf("-")+1));
            } else if (equation.indexOf("*")!=-1) {
                start = hexToTen(equation.substring(0, equation.indexOf("*"))) * hexToTen(equation.substring(equation.indexOf("*")+1));
            } else {
                start = hexToTen(equation.substring(0, equation.indexOf("/"))) / hexToTen(equation.substring(equation.indexOf("/")+1));
            }

            text.clear();
            text.appendText(String.valueOf(start));
            if (start > 2147483646) {
                text.clear();
                text.appendText("OVERFLOW ERROR");
            }
            else if (start < -9999999) {
                text.clear();
                text.appendText("UNDERFLOW ERROR");
            }
        }
        else {
            int tenBase = hexToTen(text.getText());
            text.clear();
            text.appendText(String.valueOf(tenBase));
            if (tenBase > 2147483646) {
                text.clear();
                text.appendText("OVERFLOW ERROR");
            }
            else if (tenBase < -9999999) {
                text.clear();
                text.appendText("UNDERFLOW ERROR");
            }
        }
        operator = false;
    }

    public int hexToTen(String hexValue) {
        int value = 0;
        int digits = hexValue.length() - 1;

        for (int i = 0; i < hexValue.length(); i++) {
            char digit = hexValue.charAt(i);
            int digitValue;

            if (Character.isDigit(digit)) {
                digitValue = digit - '0';
            } else {
                digitValue = Character.toUpperCase(digit) - 'A' + 10;
            }

            value += digitValue * Math.pow(16, digits);
            digits--;
        }

        return value;
    }


    public static void main(String[] args) {
        launch();
    }
}