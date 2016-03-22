package Task5;

/**
 * Created by Elizaveta on 22.03.2016.
 */
public class Marks<T extends Number> {
    private T [] marks;
    public Marks(T[] marks){
        this.marks=marks;
    }
    public T[] getMarks(){
        return marks;
    }
}
