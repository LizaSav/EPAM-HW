package Task1;

/**
 * Created by Elizaveta on 20.03.2016.
 */
public enum PenType {Gel(20), Ball(10), Fountain(30);
    int cost ;
    PenType(int cost){
        this.cost=cost;
    }
    public int getCost(){
        return cost;
    }


}
