package Task1;

import org.xml.sax.SAXException;

import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;
import java.io.File;
import java.io.IOException;

/**
 * Created by Elizaveta on 18.04.2016.
 */
public class XSDValidation {
    public static void main(String[] args) throws SAXException, IOException {
        SchemaFactory factory = SchemaFactory.newInstance("http://www.w3.org/2001/XMLSchema");
        File schemalocation = new File("src/main/resources/HomeLibrary.xsd");
        Schema schema = factory.newSchema(schemalocation);
        Validator validator = schema.newValidator();
        Source source = new StreamSource("src/main/resources/HomeLibrary.xml");
        try {
            validator.validate(source);
            System.out.println(" Valid");
        } catch (SAXException e) {
            System.out.println("Not valid ");
        }
    }
}

