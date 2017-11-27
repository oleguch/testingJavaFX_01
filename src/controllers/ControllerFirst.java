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
import sample.Main;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class ControllerFirst implements Initializable {
    @FXML
    private Button btn;
    @FXML
    private TextField fioField;
    private Change change;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        change = Main.getChange();          //очень не нравится такая реализация
        change.setFirstController(this);
        btn.setOnAction(event -> {
            if (fioField.getText().isEmpty()) {
                showMessageWarning("Не заполнено поле ФИО");
            } else
                changeForm();
        });
    }

    private void changeForm() {
        try {
            change.toSecond();
        } catch (IOException e) {
            e.printStackTrace();
        }
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
}
