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
    private Helper helper;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        btn.setOnAction(e -> {
            if (surnameField.getText().isEmpty())
                showMessageWarning("Не заполнена фамилия");
            else if (nameField.getText().isEmpty())
                showMessageWarning("Не заполнено имя");
            else if (partnameField.getText().isEmpty()){
                showMessage();
                changeForm();
            }
        });

    }

    private void showMessageWarning(String message) {
        Alert alert = new Alert(Alert.AlertType.WARNING, message, ButtonType.APPLY);
        alert.setHeaderText(null);
        alert.showAndWait();

    }

    private void showMessage() {
        Alert alert = new Alert(Alert.AlertType.WARNING,
                "Не заполнено отчество. Вы хотите его заполнить?",
                ButtonType.YES, ButtonType.CANCEL);
        alert.setHeaderText(null);
        alert.showAndWait();

        if (alert.getResult() == (ButtonType.YES)){
            partnameField.requestFocus();
        } else if (alert.getResult().equals(ButtonType.CANCEL))
            //System.out.println("NO");
            changeForm();
    }

    private void changeForm() {
        //helper.toFirstScene();
        helper.transferPerson2to1();
    }

    @Override
    public Person getPerson() {
        Person person = new Person();
        person.setSurname(surnameField.getText().isEmpty() ? null : surnameField.getText());
        person.setName(nameField.getText().isEmpty() ? null : nameField.getText());
        person.setPatronymic(partnameField.getText().isEmpty() ? null : partnameField.getText());
        return person;
    }

    @Override
    public void setPerson(Person person) {
        surnameField.setText(person.getSurname());
        nameField.setText(person.getName());
        partnameField.setText(person.getPatronymic());
    }

    @Override
    public void setControllerHelper(Helper helper) {
        this.helper = helper;
    }
}
