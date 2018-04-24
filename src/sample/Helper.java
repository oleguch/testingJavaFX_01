package sample;


import controllers.Controllers;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.stage.Stage;
import java.io.IOException;
import java.util.ArrayList;

public class Helper {
    private Stage window;
    private ArrayList<Scene> scenes = new ArrayList<>();
    private ArrayList<Controllers> controllers = new ArrayList<>();

    public Helper(Stage primaryStage) throws IOException {
        window = primaryStage;
        initialize();
        
        toFirstScene();
        controllers.get(0).setFocus(FieldError.FIELD_SURNAME_ERROR);
        window.show();
    }

	private void initialize() throws IOException {
		FXMLLoader[] loaders = {
        		new FXMLLoader(getClass().getResource("firstPane.fxml")),
        		new FXMLLoader(getClass().getResource("secondPane.fxml")),
        		new FXMLLoader(getClass().getResource("thirdPane.fxml"))
        };
        for (FXMLLoader loader : loaders) {
        	scenes.add(new Scene(loader.load()));
        	Controllers controller = loader.getController();
        	controller.addAction(change);
        	controllers.add(controller);
        }
	}

    private EventHandler<ActionEvent> change = event -> {
	    for (int i = 0; i < scenes.size(); i++) {
	    	if (window.getScene().equals(scenes.get(i))){
	    		checkScene(i);
	    		break;
	    	}
	    }
	    
	};

    private void checkScene(int indexScene) {
    	Controllers controller = controllers.get(indexScene);
    	FieldError error =checkField(controller.getPerson());
        if (error == FieldError.CHECK_OK)
            nextScene(indexScene);
        else
            controller.setFocus(error);
	}

    private FieldError checkField(Person person) {
        if (person.getSurname() == null ) {
            showMessageWarning( "Не заполнена фамилия");
            return FieldError.FIELD_SURNAME_ERROR;
        } else if (person.getName() == null) {
            showMessageWarning("Не заполнено имя");
            return FieldError.FIELD_NAME_ERROR;
        } else if (person.getPatronymic() == null ) {
            ButtonType variant = showMessagePatronymic();
            if (variant == ButtonType.CANCEL || variant == ButtonType.CLOSE) {
                return FieldError.FIELD_PATRONYMIC_EMPTY;
            } else
                return FieldError.CHECK_OK;
        } else
            return FieldError.CHECK_OK;
    }

    private ButtonType showMessagePatronymic() {
        Alert alert = new Alert(Alert.AlertType.WARNING,
                "Не заполнено отчество. Продолжить без заполнения?",
                ButtonType.YES, ButtonType.CANCEL);
        Button yesButton = (Button) alert.getDialogPane().lookupButton(ButtonType.YES);
        yesButton.setText("Да");
        Button cancelButton = (Button) alert.getDialogPane().lookupButton(ButtonType.CANCEL);
        cancelButton.setText("Отмена");
        alert.setHeaderText(null);
        alert.initOwner(window);
        alert.showAndWait();

        return alert.getResult();

    }

    private void showMessageWarning(String message) {
        Alert alert = new Alert(Alert.AlertType.ERROR, message);
        alert.setHeaderText(null);
        alert.initOwner(window);
        alert.show();
    }

    private void toFirstScene() {
    	window.setScene(scenes.get(0));
    }

    private void nextScene(int indexScene) {
    	int lastIndex = scenes.size() - 1;
    	int afterIndex = indexScene == lastIndex ? 0 : indexScene + 1;
    	controllers.get(afterIndex).setPerson(controllers.get(indexScene).getPerson());
    	window.setScene(scenes.get(afterIndex));
    }

}
