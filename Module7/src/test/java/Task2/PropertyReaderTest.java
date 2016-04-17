package Task2;

import org.junit.Test;
import java.io.File;

/**
 * Created by Elizaveta on 17.04.2016.
 */
class TestThread implements Runnable{
    PropertyReader pr;
    public TestThread(PropertyReader pr){
        this.pr=pr;
    }
    @Override
    public void run() {
        System.out.println(pr.getProperty("key1"));
    }
}
public class PropertyReaderTest {
    @Test
    public void getPropertyTest(){
        PropertyReader propertyReader = new PropertyReader(new File("src/main/resources/prop.properties"));
        Thread t1 = new Thread(new TestThread(propertyReader));
        Thread t2 = new Thread(new TestThread(propertyReader));
        t1.start();
        t2.start();
    }
}
