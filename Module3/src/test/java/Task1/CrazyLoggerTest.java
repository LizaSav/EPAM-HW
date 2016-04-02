package Task1;

import org.junit.Test;

import java.io.File;
import java.io.IOException;

import static org.junit.Assert.*;

/**
 * Created by Elizaveta on 31.03.2016.
 */
public class CrazyLoggerTest {
    @Test
    public void loggerTest() throws IOException {
        File file=new File("src/main/resources/log.txt");
        CrazyLogger log=new CrazyLogger(file, 2);
        log.logger("lall");
        log.logger("bubub");
        log.close();
    }

}