package sample;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {
    private static Change change;

    @Override
    public void start(Stage primaryStage) throws Exception{
        Stage stage = primaryStage;
        stage.setTitle("Hello World");
        change = new Change(stage);
        change.toFirst();
        stage.show();

    }


    public static void main(String[] args) {
        launch(args);
    }

    public static Change getChange() {
        return change;
    }

}
