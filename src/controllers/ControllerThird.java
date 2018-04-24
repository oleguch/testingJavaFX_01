package controllers;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import sample.FieldError;
import sample.Person;

public class ControllerThird implements Controllers{
	
	@FXML
    private Button btn;
    @FXML
    private TextField surnameField;
    
    @FXML
    private TextField namePartnameField;
    
    @Override
    public Person getPerson() {
    	Person person = new Person();
		person.setSurname(surnameField.getText().isEmpty() ? null : surnameField.getText());
		String[] namePartname = namePartnameField.getText().trim().split("\\s+");
		if (namePartname.length >= 1)
            person.setName(namePartname[0]);
        if (namePartname.length >=2 )
            person.setPatronymic(namePartname[1]);
        return person;
    }

    @Override
    public void setPerson(Person person) {
    	surnameField.setText(person.getSurname());
    	if (person.getPatronymic().isEmpty())
    		namePartnameField.setText(person.getName());
    	else
    		namePartnameField.setText(person.getName() + " " + person.getPatronymic());
    }

    @Override
    public void addAction(EventHandler<ActionEvent> event) {
    	btn.setOnAction(event);
		surnameField.setOnAction(event);
		namePartnameField.setOnAction(event);
    }

    @Override
    public void setFocus(FieldError field) {
    	switch (field) {
		case FIELD_SURNAME_ERROR:
            setFocusToSurname();
            break;
        case FIELD_NAME_ERROR:
        case FIELD_PATRONYMIC_EMPTY:
            setFocusToNamePartname();
            break;
		default:
			break;

	}
    }

	private void setFocusToNamePartname() {
		namePartnameField.requestFocus();
	}

	private void setFocusToSurname() {
		surnameField.requestFocus();
	}
}
