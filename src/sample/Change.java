package sample;

import controllers.ControllerFirst;
import controllers.ControllerSecond;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Change {
    private static String fileFirst = "firstPane.fxml";
    private static String fileSecond = "secondPane.fxml";
    private Stage stage;
    private ControllerFirst firstController;
    private ControllerSecond secondController;

    public Change(Stage stage) throws IOException {
        this.stage = stage;
    }

    private Parent getFirstParent() throws IOException {
        return FXMLLoader.load(getClass().getResource(fileFirst));
    }

    private Parent getSecondParent() throws IOException {
        return FXMLLoader.load(getClass().getResource(fileSecond));
    }

    public void toFirst() throws IOException {
        setScene(getFirstParent());
    }

    public void toSecond() throws IOException {
        setScene(getSecondParent());
    }

    private void setScene(Parent parent) {
        stage.setScene(new Scene(parent, 400, 300));
    }

    public void setFirstController(ControllerFirst firstController) {
        this.firstController = firstController;
    }

    public void setSecondController(ControllerSecond secondController) {
        this.secondController = secondController;
    }
}
