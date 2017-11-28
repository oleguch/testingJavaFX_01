package controllers;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import sample.Person;

import java.net.URL;
import java.util.ResourceBundle;

public class ControllerFirst implements Initializable, Controllers {
    @FXML
    private Button btn;
    @FXML
    private TextField fioField;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
    }

    @Override
    public void addAction(EventHandler<ActionEvent> event) {
        btn.setOnAction(event);
        fioField.setOnAction(event);
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


    public void setFocusToField() {
        fioField.requestFocus();
    }
}
