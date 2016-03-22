package Task2;

import Task3.Stationery;

/**
 * Created by Elizaveta on 21.03.2016.
 */
public class Clips extends Stationery{
    private int quantity;

    public Clips(int quantity){
        this.quantity=quantity;
    }
    public int getCost(){
        return quantity;
    }
    public void inkr(int inkr) {
        if ((inkr < 0) && (quantity + inkr < 0)) throw new RuntimeException();
        quantity += inkr;
    }
    public String getName(){
        return "Clips";
    }
}
