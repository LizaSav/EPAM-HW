package Task4;

import Task3.Stationery;

import java.util.Comparator;

/**
 * Created by Elizaveta on 22.03.2016.
 */
public class StationeryCostComparator implements Comparator<Stationery> {
    public int compare(Stationery ob1, Stationery ob2){
        return ob1.getCost()-ob2.getCost();
    }

}
