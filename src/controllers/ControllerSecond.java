package controllers;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import sample.Person;

import java.net.URL;
import java.util.ResourceBundle;

public class ControllerSecond implements Initializable, Controllers {
    public TextField surnameField;
    public TextField nameField;
    public TextField patronymic;
    public Button btn;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    @Override
    public void addAction(EventHandler<ActionEvent> event) {
        btn.setOnAction(event);
        surnameField.setOnAction(event);
        nameField.setOnAction(event);
        patronymic.setOnAction(event);
    }

    @Override
    public Person getPerson() {
        Person person = new Person();
        person.setSurname(surnameField.getText().isEmpty() ? null : surnameField.getText());
        person.setName(nameField.getText().isEmpty() ? null : nameField.getText());
        person.setPatronymic(patronymic.getText().isEmpty() ? null : patronymic.getText());
        return person;
    }

    @Override
    public void setPerson(Person person) {
        surnameField.setText(person.getSurname());
        nameField.setText(person.getName());
        patronymic.setText(person.getPatronymic());
    }


    public void setFocusToSurname() {
        surnameField.requestFocus();
    }

    public void setFocusToName() {
        nameField.requestFocus();
    }

    public void setFocusToPatronymic() {
        patronymic.requestFocus();
    }
}
