package Task2;

import Task3.Stationery;

/**
 * Created by Elizaveta on 21.03.2016.
 */
public class Notebook extends Stationery {
    private int cost;
    private boolean type;
    public Notebook(int cost){
        this.cost=cost;
    }
    public int getCost(){
        return cost;
    }
    public String getType(){ return type? "square lined":"lined";}

    public String getName(){
        return "Notebook";
    }
}
