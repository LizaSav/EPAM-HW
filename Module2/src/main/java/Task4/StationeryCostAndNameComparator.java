package Task4;

import Task3.Stationery;

import java.util.Comparator;

/**
 * Created by Elizaveta on 22.03.2016.
 */
public class StationeryCostAndNameComparator implements Comparator<Stationery> {
    public int compare(Stationery ob1, Stationery ob2){
        return (new StationeryCostComparator()).compare(ob1,ob2)*10000000+(new StationeryNameComparator().compare(ob1, ob2));

    }
}
