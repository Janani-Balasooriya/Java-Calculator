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
    }

    public void updateDisplays(String text){
        String smallDisplayText;
        String largeDisplayText;
        if ((text.equals("+")) || (text.equals("-")) || (text.equals("/")) || (text.equals("*"))){

        }else if (label_largeDisplay.getText().equals("0")){
           largeDisplayText = text;
        }else {
            largeDisplayText = label_largeDisplay.getText() + text;
        }


    }

    public void doCalculation(String operation){
        double number1 = Double.parseDouble(label_largeDisplay.getText());
        double number2 = Double.parseDouble(label_smallDisplay.getText());

//        if (Stringutils)
//        switch (operation) {
//            case "+" :
//                number1 + number2;
//        }
    }
}