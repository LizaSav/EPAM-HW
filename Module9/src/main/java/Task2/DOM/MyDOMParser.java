package Task2.DOM;

import Task2.Food;
import com.sun.org.apache.xerces.internal.parsers.DOMParser;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by Elizaveta on 18.04.2016.
 */
public class MyDOMParser {
    private static final String MENU_XML = "src/main/resources/menu.xml";
    public static void main(String[] args) throws IOException, SAXException {

        DOMParser parser = new DOMParser();
        parser.parse(MENU_XML);
        Element root = parser.getDocument().getDocumentElement();

        ArrayList<Food> foodList = new ArrayList<>();
        Food food;
        NodeList nodeList = root.getElementsByTagName("food");
        for(int i=0; i<nodeList.getLength(); i++){
            Element element=(Element)nodeList.item(i);
            food=new Food(Integer.parseInt(element.getAttribute("id")));
            getChildTags(food, element);
            foodList.add(food);
        }

        System.out.println(foodList);
    }

    private static void getChildTags(Food food, Element element){
        String name = getElementByTagName(element, "name").getTextContent().trim();
        String price = getElementByTagName(element, "price").getTextContent().trim();
        int calories = Integer.parseInt(getElementByTagName(element, "calories").getTextContent().trim());
        String description = getElementByTagName(element, "description").getTextContent().trim();
        food.setName(name);
        food.setPrice(price);
        food.setDescription(description);
        food.setCalories(calories);
    }

    private static Element getElementByTagName(Element element, String childName){
        return (Element) element.getElementsByTagName(childName).item(0);
    }
}
