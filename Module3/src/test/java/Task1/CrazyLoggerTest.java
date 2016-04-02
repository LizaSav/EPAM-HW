package Task1;

import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Date;

/**
 * Created by Elizaveta on 31.03.2016.
 */
public class CrazyLoggerTest {
    @Test
    public void loggerTest() throws IOException {
        File file=new File("src/main/resources/log.txt");
        CrazyLogger log=new CrazyLogger(file, 2);
        log.error("lall");
        log.info("bubub");
        log.close();
    }

    @Test
    public void getByDateTest() throws IOException {
        File file=new File("src/main/resources/log.txt");
        CrazyLogger log=new CrazyLogger(file);
        OutputStreamWriter out= new OutputStreamWriter(System.out);
        Date date = new Date(116, 3,2);
        log.getByDate(out, date);
        out.close();
    }

    @Test
    public void getByLevelTest() throws IOException {
        File file=new File("src/main/resources/log.txt");
        CrazyLogger log=new CrazyLogger(file);
        OutputStreamWriter out= new OutputStreamWriter(System.out);
        log.getByLevel(out, "WARNING");
        out.close();
    }

}