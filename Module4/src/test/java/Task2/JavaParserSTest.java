package Task2;

import org.junit.Test;
import java.io.File;
import java.io.IOException;

public class JavaParserSTest {
    @Test
    public void parseTest() throws IOException {//в выходном файле не должно быть new
        File in =new File("src/main/resources/input.txt");
        File out =new File("src/main/resources/output.txt");
        JavaParserS.parse(in, out);

    }
}
