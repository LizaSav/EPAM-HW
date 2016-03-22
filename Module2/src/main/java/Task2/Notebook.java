package Task2;

/**
 * Created by Elizaveta on 21.03.2016.
 */
public class Notebook {
    private int cost;
    private boolean type;
    public Notebook(int cost){
        this.cost=cost;
    }
    public int getCost(){
        return cost;
    }
    public String getType(){ return type? "square lined":"lined";}
}
