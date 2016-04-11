package Task2;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by Elizaveta on 11.04.2016.
 */

public class PropertiesReaderTest {
@Test
    public void getPropertyTest(){
    assertEquals("value1",PropertiesReader.getProperty("src/main/resources/prop.properties", "key1"));
    assertEquals("value3",PropertiesReader.getProperty("src/main/resources/prop.properties", "key3"));
    assertEquals(null,PropertiesReader.getProperty("src/main/resources/prop.properties", "key4"));
}
}
