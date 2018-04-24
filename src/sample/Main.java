package sample;

import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        primaryStage.setTitle("JavaFX Application");
        Helper helper = new Helper(primaryStage);

    }


    public static void main(String[] args) {
        launch(args);

    }


}
