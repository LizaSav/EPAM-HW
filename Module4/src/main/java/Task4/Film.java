package Task4;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Elizaveta on 08.04.2016.
 */
public class Film implements Serializable {
    private String title;
    private HashSet<Actor>  actors;

    public Film(String title) {
        this.title = title;
        actors= new HashSet<>();
    }
    public Film addActor(Actor actor){
        actors.add(actor);
        return this;
    }

    @Override
    public String toString() {
        return "Film{" +
                "title='" + title + '\'' +
                " actors=" + actors +
                '}';
    }

    public String getTitle() {
        return title;
    }

    public Film changeTitle(String title){
        this.title=title;
        return this;
    }
}
