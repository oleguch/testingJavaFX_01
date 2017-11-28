package sample;

import controllers.Controllers;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Helper {
    private Scene scene1;
    private Scene scene2;
    private Controllers controller1;
    private Controllers controller2;
    private Stage window;

    public Helper(Stage primaryStage) throws IOException {
        window = primaryStage;
        FXMLLoader loader1 = new FXMLLoader(getClass().getResource("firstPane.fxml"));
        scene1 = new Scene(loader1.load());
        FXMLLoader loader2 = new FXMLLoader(getClass().getResource("secondPane.fxml"));
        scene2 = new Scene(loader2.load());
        controller1 = loader1.getController();
        controller2 = loader2.getController();
        controller1.setControllerHelper(this);
        controller2.setControllerHelper(this);

        toFirstScene();
    }



    public void toFirstScene() {
        window.setScene(scene1);
        window.show();

    }
}
