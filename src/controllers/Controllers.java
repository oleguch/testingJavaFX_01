package controllers;

import sample.Helper;
import sample.Person;

public interface Controllers {
    public Person getPerson();

    public void setPerson(Person person);

    public void setControllerHelper(Helper helper);

}
