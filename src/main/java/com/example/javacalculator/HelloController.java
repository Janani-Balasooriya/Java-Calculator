package com.example.javacalculator;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import java.net.URL;
import java.util.ResourceBundle;

public class HelloController implements Initializable {
    private boolean isNewNumber = true;
    @FXML
    private Label label_largeDisplay;

    @FXML
    private Label label_smallDisplay;

    @FXML
    private Button btn_1;

    @FXML
    private Button btn_2;

    @FXML
    private Button btn_3;

    @FXML
    private Button btn_4;

    @FXML
    private Button btn_5;

    @FXML
    private Button btn_6;

    @FXML
    private Button btn_7;

    @FXML
    private Button btn_8;

    @FXML
    private Button btn_9;

    @FXML
    private Button btn_0;

    @FXML
    private Button btn_add;

    @FXML
    private Button btn_substract;

    @FXML
    private Button btn_multiply;

    @FXML
    private Button btn_divide;

    @FXML
    private Button btn_equal;

    @FXML
    private Button btn_dot;

    @FXML
    private Button btn_C;

    @FXML
    protected void onHelloButtonClick() {

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        btn_1.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                System.out.println("button 1 clicked");
                updateDisplays("1");
            }
        });
        btn_2.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                updateDisplays("2");
            }
        });
        btn_3.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                updateDisplays("3");
            }
        });
        btn_4.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                updateDisplays("4");
            }
        });
        btn_5.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                updateDisplays("5");
            }
        });
        btn_6.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                updateDisplays("6");
            }
        });
        btn_7.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                updateDisplays("7");
            }
        });
        btn_8.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                updateDisplays("8");
            }
        });
        btn_9.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                updateDisplays("9");
            }
        });
        btn_0.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                updateDisplays("0");
            }
        });
        btn_add.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                doCalculation("+");
            }
        });
        btn_substract.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                doCalculation("-");
            }
        });
        btn_multiply.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                doCalculation("x");
            }
        });
        btn_divide.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                doCalculation("/");
            }
        });

        btn_C.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                clearDisplays();
            }
        });
    }

    public void updateDisplays(String text){

        String smallDisplayText = label_smallDisplay.getText();
        String LargeDisplayText = label_largeDisplay.getText();

        if (LargeDisplayText.equals("0")){
            System.out.println("0");
           LargeDisplayText = text;
           label_largeDisplay.setText(LargeDisplayText);
        }else {
            if (isNewNumber){
                label_largeDisplay.setText(text);
                isNewNumber = false;
            }else{
                label_largeDisplay.setText(LargeDisplayText + text);
            }
        }
    }

    public void doCalculation(String operation){
        isNewNumber = true;
        String SmallDisplayValue = label_smallDisplay.getText();
        String LargeDisplayValue = label_largeDisplay.getText();

        double number1 = Double.parseDouble(LargeDisplayValue);

        if (SmallDisplayValue.isEmpty()){ // small display is empty
            label_smallDisplay.setText(number1 + operation);
        }else { // small display must have an operation
            if (SmallDisplayValue.contains("=")){
                label_smallDisplay.setText(LargeDisplayValue+operation);
            }else { // else it has one of the operations + - * /
                char lastOperation = SmallDisplayValue.charAt(SmallDisplayValue.length() - 1);
                double lastNumber = Double.parseDouble(SmallDisplayValue.substring(0,SmallDisplayValue.length()-2));
                System.out.println("last operation" + lastOperation);
                System.out.println("last number" + lastNumber);
                try {
                    double output = 0;
                    switch (lastOperation) {
                        case '+':
                            output = lastNumber + number1;
                            LargeDisplayValue = output + "";
                            SmallDisplayValue = output + operation;
                            break;
                        case '-':
                            output = lastNumber - number1;
                            LargeDisplayValue = output + "";
                            SmallDisplayValue = output + operation;
                            break;
                        case 'x':
                            output = lastNumber * number1;
                            LargeDisplayValue = output + "";
                            SmallDisplayValue = output + operation;
                            break;
                        case '/':
                            output = lastNumber / number1;
                            LargeDisplayValue = output + "";
                            SmallDisplayValue = output + operation;
                            break;
                        default:
                            System.out.println("Not sure");
                            break;
                    }
                } finally {
                    label_largeDisplay.setText(LargeDisplayValue);
                    label_smallDisplay.setText(SmallDisplayValue);
                }
            }
        }
    }

    public void clearDisplays(){
        label_largeDisplay.setText("");
        label_smallDisplay.setText("");
    }
}