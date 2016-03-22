package Task4;

import Task2.Clips;
import Task2.Notebook;
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
        LinkedList<Stationery> stationeries =Chief.askChiefStartKit();
        System.out.println("Before sorting:" +stationeries);
        stationeries.sort(new StationeryCostComparator());
        System.out.println("After Cost sorting:"+stationeries);
        assertEquals("Notebook", stationeries.get(stationeries.size()-2).getName());

        stationeries.sort(new StationeryNameComparator());
        System.out.println("After Name sorting:"+stationeries);
        assertEquals("Clips", stationeries.getFirst().getName());
    }
    @Test
    public void StationeryCostAndNameComparatorTest(){
        LinkedList<Stationery> list=new LinkedList<Stationery>();
        list.add(new Notebook(10));
        list.add(new Notebook(30));
        list.add(new Clips(20));
        list.add(new Clips(10));
        System.out.println(list);
        list.sort(new StationeryCostAndNameComparator());
        System.out.println(list);
        assertEquals("Clips",list.getFirst().getName());
    }
}
