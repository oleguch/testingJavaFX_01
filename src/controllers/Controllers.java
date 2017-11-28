package controllers;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import sample.Person;

public interface Controllers {
    Person getPerson();

    void setPerson(Person person);

    void addAction(EventHandler<ActionEvent> event);


}
