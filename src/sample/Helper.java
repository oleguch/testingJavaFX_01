package sample;

import controllers.ControllerFirst;
import controllers.ControllerSecond;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.stage.Stage;

import java.io.IOException;

public class Helper {
    private Scene scene1;
    private Scene scene2;
    private ControllerFirst controller1;
    private ControllerSecond controller2;
    private Stage window;
    private static final int CHECK_OK = 0,
            FIELD_SURNAME_ERROR = 1,
            FIELD_NAME_ERROR = 2,
            FIELD_PATRONYMIC_EMPTY = 3;

    public Helper(Stage primaryStage) throws IOException {
        window = primaryStage;
        FXMLLoader loader1 = new FXMLLoader(getClass().getResource("firstPane.fxml"));
        scene1 = new Scene(loader1.load());
        FXMLLoader loader2 = new FXMLLoader(getClass().getResource("secondPane.fxml"));
        scene2 = new Scene(loader2.load());
        controller1 = loader1.getController();
        controller2 = loader2.getController();
        controller1.addAction(change);
        controller2.addAction(change);
        toFirstScene();
        window.show();
    }

    private EventHandler change = new EventHandler() {
        @Override
        public void handle(Event event) {
            if (window.getScene().equals(scene1))
                 checkSceneFirst();
            else checkSceneSecond();
        }
    };

    private void checkSceneSecond() {
        switch (checkField(controller2.getPerson())) {
            case CHECK_OK:
                transferPerson2to1();
                break;
            case FIELD_SURNAME_ERROR:
                controller2.setFocusToSurname();
                break;
            case FIELD_NAME_ERROR:
                controller2.setFocusToName();
                break;
            case FIELD_PATRONYMIC_EMPTY:
                controller2.setFocusToPatronymic();
                break;
        }
    }
    private void checkSceneFirst() {
        switch (checkField(controller1.getPerson())) {
            case CHECK_OK:
                transferPerson1to2();
                break;
            case FIELD_SURNAME_ERROR:
            case FIELD_NAME_ERROR:
            case FIELD_PATRONYMIC_EMPTY:
                controller1.setFocusToField();
                break;
        }
    }

    private int checkField(Person person) {
        if (person.getSurname() == null ) {
            showMessageWarning( "Не заполнена фамилия");
            return FIELD_SURNAME_ERROR;
        } else if (person.getName() == null) {
            showMessageWarning("Не заполнено имя");
            return FIELD_NAME_ERROR;
        } else if (person.getPatronymic() == null ) {
            ButtonType variant = showMessagePatronymic();
            if (variant == ButtonType.CANCEL || variant == ButtonType.CLOSE) {
                return FIELD_PATRONYMIC_EMPTY;
            } else
                return CHECK_OK;
        } else
            return CHECK_OK;
    }

    private ButtonType showMessagePatronymic() {
        Alert alert = new Alert(Alert.AlertType.WARNING,
                "Не заполнено отчество. Продолжить без заполнения?",
                ButtonType.YES, ButtonType.CANCEL);
        alert.setHeaderText(null);
        alert.showAndWait();

        return alert.getResult();

    }

    private void showMessageWarning(String message) {
        Alert alert = new Alert(Alert.AlertType.WARNING, message, ButtonType.APPLY);
        alert.setHeaderText(null);
        alert.show();
    }

    private void toFirstScene() {
        window.setScene(scene1);
    }
    private void toSecondScene() {
        window.setScene(scene2);
    }

    private void transferPerson1to2(){
        controller2.setPerson(controller1.getPerson());
        toSecondScene();

    }
    private void transferPerson2to1(){
        controller1.setPerson(controller2.getPerson());
        toFirstScene();
    }
}
