package Task2;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by Elizaveta on 19.03.2016.
 */
public class MinElementTest {
    @Test
    public void getMinElementTest()throws Exception {
        assertEquals("eps=1",MinElement.getMinElement(1.0), 1);
        assertEquals("eps=0.05",MinElement.getMinElement(0.05), 4);
    }
}
