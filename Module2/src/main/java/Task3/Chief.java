package Task3;

import Task1.Pen;
import Task1.PenType;
import Task2.Clips;
import Task2.Employee;
import Task2.Notebook;

import java.awt.*;
import java.util.LinkedList;

/**
 * Created by Elizaveta on 22.03.2016.
 */
public   class Chief extends Employee {
    public Chief(){
        super("X","X", "7777");
    }

    public static LinkedList<Stationery> askChiefStartKit(){
        LinkedList<Stationery> stationery =new LinkedList<Stationery>();
        for(int i=0; i<3; i++) {
            stationery.add(new Pen(PenType.Ball, Color.black, 0.1));
            stationery.add(new Clips(50));
            stationery.add(new Notebook(100));
        }
        return stationery;
    }
}
