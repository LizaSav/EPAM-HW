package Task5;


import java.lang.reflect.Type;

/**
 * Created by Elizaveta on 22.03.2016.
 */
public enum Subjects {Algebra(true), Prog(true), Geom(false), Calculus(false);
    boolean type;
    Subjects(boolean type){
        this.type=type;
    }
}
