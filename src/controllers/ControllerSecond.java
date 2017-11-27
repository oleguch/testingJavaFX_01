package controllers;

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

public class ControllerSecond implements Initializable{
    public TextField surnameField;
    public TextField nameField;
    public TextField partnameField;
    public Button btn;
    private static Change change;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        btn.setOnAction(e -> {
            if (surnameField.getText().isEmpty())
                showMessageWarning("Не заполнена фамилия");
            else if (nameField.getText().isEmpty())
                showMessageWarning("Не заполнено имя");
            else {
                change = Main.getChange();

                try {
                    change.toFirst();
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            }
        });
    }

    private void showMessageWarning(String message) {
        Alert alert = new Alert(Alert.AlertType.WARNING, message, ButtonType.APPLY);
        alert.setHeaderText(null);
        alert.show();
    }
}
