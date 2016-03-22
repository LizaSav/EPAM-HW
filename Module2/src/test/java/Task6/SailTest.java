package Task6;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

/**
 * Created by Elizaveta on 22.03.2016.
 */
public class SailTest {
    @Test
    public void getResultSailTest(){
        NuclearBoat boat =new NuclearBoat(100,200,1000);
        Sail sail1=new Sail(boat,1000, 50);
        assertTrue(sail1.isSaveSail());
        sail1.getResultSail();
        Sail sail2=new Sail(boat, 15000, 150);
        sail2.getResultSail();
    }
}
