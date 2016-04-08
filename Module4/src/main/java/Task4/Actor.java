package Task4;

import java.io.Serializable;

/**
 * Created by Elizaveta on 08.04.2016.
 */
public class Actor implements Serializable {
    private String name;
    private  String surname;

    public Actor(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }

    @Override
    public String toString() {
        return name +" "+ surname;
    }
}
