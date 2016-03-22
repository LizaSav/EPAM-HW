package Task2;

import Task1.PenType;
import org.junit.Test;
import java.awt.*;

import static org.junit.Assert.assertEquals;
/**
 * Created by Elizaveta on 21.03.2016.
 */
public class EmployeeTest {
    @Test
    public void getFullCostTest(){
        Employee emp =new Employee("A", "B", "37586");
        emp.addPen(new Task1.Pen(PenType.Ball, Color.black, 0.1 )).addClips(10).addNotebook(new Notebook(50));
        assertEquals(70,emp.getFullCost());
        emp.addPen(new Task1.Pen(PenType.Gel, Color.blue, 0.5)).addClips(11);
        emp.removePen(new Task1.Pen(PenType.Gel, Color.blue, 0.5)).removeClips(1);
        assertEquals(80,emp.getFullCost());
    }
}
