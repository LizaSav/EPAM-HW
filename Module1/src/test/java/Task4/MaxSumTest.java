package Task4;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

/**
 * Created by Elizaveta on 20.03.2016.
 */
public class MaxSumTest {
    @Test
    public void getMaxSumTest()throws Exception{
        assertEquals(3,MaxSum.getMaxSum(new double[]{-1,0,3,-3}),0.00001);
        assertEquals(0,MaxSum.getMaxSum(new double[]{0}),0.00001);
    }
}
