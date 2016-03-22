package Task2;

/**
 * Created by Elizaveta on 21.03.2016.
 */
public class Clips {
    private int quantity;

    public Clips(int quantity){
        this.quantity=quantity;
    }
    public int getCost(){
        return quantity;
    }
    public void inkr(int inkr){
        if((inkr<0)&&(quantity+inkr<0)) throw new RuntimeException();
        quantity+=inkr;
    }
}
