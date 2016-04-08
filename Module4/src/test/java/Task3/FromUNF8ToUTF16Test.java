package Task3;

import org.junit.Test;

import java.io.File;
import java.io.IOException;

/**
 * Created by Elizaveta on 08.04.2016.
 */
public class FromUNF8ToUTF16Test {
    @Test//  не знаю как понять работает или нет
    public void changeEncoding() throws IOException {
        File utf8= new File("src/main/resources/UTF-8.txt");
        File utf16= new File("src/main/resources/UTF-16.txt");
        FromUNF8ToUTF16.changeEncoding(utf8,utf16);
    }
}
