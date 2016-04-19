package Task2.SAX;

import Task2.Food;
import org.xml.sax.Attributes;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.helpers.XMLReaderFactory;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Elizaveta on 18.04.2016.
 */
public class SAXParser extends DefaultHandler {
    private static final  String MENU_XML = "src/main/resources/menu.xml";
    private ArrayList<Food> foodList = new ArrayList<>();
    private Food food;
    private StringBuffer value;
    public ArrayList<Food> getFoodList(){
        return foodList;
    }
    public void startElement(String uri, String localName, String qName, Attributes atts){
        value= new StringBuffer();
        if(qName.equals("food")){
            food=new Food(Integer.parseInt(atts.getValue("id")));
        }
    }
    public void characters(char[] buffer, int start, int length) {
        value.append(buffer, start, length);
    }

    public  void endElement(String uri, String localName, String qName){
         switch (qName){
             case "name":{
                 food.setName(value.toString());
                 break;
             }
             case "price":{
                 food.setPrice(value.toString());
                 break;
             }
             case "description":{
                 food.setDescription(value.toString());
                 break;
             }
             case "calories":{
                 food.setCalories(Integer.parseInt(value.toString()));
                 break;
             }
             case "food":{
                 foodList.add(food);
                 break;
             }
         }
     }



    public static void main(String[] args) throws SAXException, IOException {
        XMLReader reader = XMLReaderFactory.createXMLReader();
        SAXParser handler = new SAXParser();
        reader.setContentHandler(handler);
        reader.parse(new InputSource(MENU_XML));
        List<Food> menu = handler.getFoodList();
        System.out.println(menu);
    }

}
