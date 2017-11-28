package controllers;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextField;
import sample.Change;
import sample.Helper;
import sample.Main;
import sample.Person;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class ControllerFirst implements Initializable, Controllers {
    @FXML
    private Button btn;
    @FXML
    private TextField fioField;
    private Change change;
    private Helper helper;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
//        change = Main.getChange();          //очень не нравится такая реализация
//        change.setFirstController(this);
        btn.setOnAction(event -> {
            if (fioField.getText().isEmpty()) {
                showMessageWarning("Не заполнено поле ФИО");
            } else
                changeForm();
        });
    }

    private void changeForm() {
        //change.toSecond();
        helper.transferPerson1to2();
    }

    private void showMessageWarning(String message) {
        Alert alert = new Alert(Alert.AlertType.WARNING, message, ButtonType.APPLY);
        alert.setHeaderText(null);
        alert.show();
    }

    public Button getBtn() {
        return btn;
    }

    public void addAction(EventHandler<ActionEvent> qqw) {
        btn.setOnAction(qqw);
    }

    @Override
    public Person getPerson() {
        Person person = new Person();
        String fio[] = fioField.getText().split("\\s+");
        if (!fioField.getText().isEmpty())
            person.setSurname(fio[0]);
        if (fio.length >= 2)
            person.setName(fio[1]);
        if (fio.length >=3 )
            person.setPatronymic(fio[2]);
        return person;
    }

    @Override
    public void setPerson(Person person) {
        if (person.getPatronymic() == null)
            fioField.setText(person.getSurname() + " " + person.getName());
        else
            fioField.setText(person.getSurname() + " " + person.getName() + " " + person.getPatronymic());
    }

    @Override
    public void setControllerHelper(Helper helper) {
        this.helper = helper;
    }
}
