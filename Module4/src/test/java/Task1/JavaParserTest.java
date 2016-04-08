package Task1;

import org.junit.Test;
import java.io.File;
import java.io.IOException;

/**
 * Created by Elizaveta on 07.04.2016.
 */
public class JavaParserTest {
    @Test
    public void parseTest() throws IOException {//в выходном файле не должно быть new
        File in =new File("src/main/resources/input.txt");
        File out =new File("src/main/resources/output.txt");
        JavaParser.parse(in, out);

    }
}
