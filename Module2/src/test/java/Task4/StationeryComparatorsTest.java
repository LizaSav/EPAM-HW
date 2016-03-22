package Task4;

import Task3.Chief;
import Task3.Stationery;
import org.junit.Test;

import java.util.Comparator;
import java.util.LinkedList;

import static org.junit.Assert.assertEquals;

/**
 * Created by Elizaveta on 22.03.2016.
 */
public class StationeryComparatorsTest {

    @Test
    public void StationeryComparatorsTest(){
        Comparator<Stationery> costComparator= new StationeryCostComparator();
        LinkedList<Stationery> stationeries =Chief.askChiefStartKit();
        System.out.println("Before sorting:" +stationeries);
        stationeries.sort(costComparator);
        System.out.println("After Cost sorting:"+stationeries);
        assertEquals("Notebook", stationeries.get(stationeries.size()-2).getName());

        Comparator<Stationery> nameComparator = new StationeryNameComparator();
        stationeries.sort(nameComparator);
        System.out.println("After Name sorting:"+stationeries);
        assertEquals("Clips", stationeries.getFirst().getName());
    }
}
