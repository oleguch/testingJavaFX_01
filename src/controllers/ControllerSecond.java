package controllers;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import sample.Change;
import sample.Helper;
import sample.Main;
import sample.Person;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class ControllerSecond implements Initializable, Controllers {
    public TextField surnameField;
    public TextField nameField;
    public TextField partnameField;
    public Button btn;
    private static Change change;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
//        change = Main.getChange();          //как мне не нравится такая реализация...
//        change.setSecondController(this);
        btn.setOnAction(e -> {
            if (surnameField.getText().isEmpty())
                showMessageWarning("Не заполнена фамилия");
            else if (nameField.getText().isEmpty())
                showMessageWarning("Не заполнено имя");
            else {
                changeForm();
            }
        });

    }

    private void showMessageWarning(String message) {
        Alert alert = new Alert(Alert.AlertType.WARNING, message, ButtonType.APPLY);
        alert.setHeaderText(null);
        alert.showAndWait();

    }

    private void showMessage(String message) {
        Alert alert = new Alert(Alert.AlertType.WARNING, message, ButtonType.YES, ButtonType.CANCEL);
        alert.setHeaderText(null);
        alert.showAndWait();
        if (alert.getResult() == (ButtonType.YES)){
            partnameField.requestFocus();
        } else if (alert.getResult().equals(ButtonType.CANCEL))
            System.out.println("NO");
    }

    private void changeForm() {
        try {
            change.toFirst();
        } catch (IOException e1) {
            e1.printStackTrace();
        }
    }

    @Override
    public Person getPerson() {
        return null;
    }

    @Override
    public void setPerson(Person person) {

    }

    @Override
    public void setControllerHelper(Helper helper) {

    }
}
