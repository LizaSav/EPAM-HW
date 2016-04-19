package Task2.StAX;

import Task2.Food;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;



/**
 * Created by Elizaveta on 18.04.2016.
 */
public class StAXParser {
    public static void main(String[] args) throws XMLStreamException, IOException {
        try (InputStream input = new FileInputStream(MENU_XML)) {
            System.out.println(
                    process(XMLInputFactory.newInstance().createXMLStreamReader(input)));
        }
    }

    private static final  String MENU_XML = "src/main/resources/menu.xml";

    private static ArrayList<Food> process(XMLStreamReader reader)
            throws XMLStreamException {
        ArrayList<Food> foodList = new ArrayList<>();
        Food food = null;
        String localName="" ;
        while (reader.hasNext()) {
            int type = reader.next();
            switch (type) {
                case XMLStreamConstants.START_ELEMENT: {
                    localName = reader.getLocalName();
                    switch (localName) {
                        case "food": {
                            food = new Food(Integer.parseInt(reader.getAttributeValue(null, "id")));
                            break;
                        }
                    }
                    break;
                }
                case XMLStreamConstants.CHARACTERS: {
                    String value = reader.getText().trim();
                    if (value.isEmpty()) break;
                    switch (localName) {
                        case "name": {
                            food.setName(value);
                            break;
                        }
                        case "price": {
                            food.setPrice(value);
                            break;
                        }
                        case "description": {
                            food.setDescription(value);
                            break;
                        }
                        case "calories": {
                            food.setCalories(Integer.parseInt(value));
                            break;
                        }
                    }
                    break;
                }
                case XMLStreamConstants.END_ELEMENT: {
                    localName=reader.getLocalName();
                    switch (localName) {
                        case "food": {
                            foodList.add(food);
                            break;
                        }
                    }
                    break;
                }
            }
        }
        return foodList;
    }

}
