package Task2;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.Enumeration;
import java.util.Locale;
import java.util.ResourceBundle;

/**
 * Created by Elizaveta on 03.04.2016.
 */
public class QuestionAnswer {
    private Locale locale;
    private ResourceBundle bundle;

    public QuestionAnswer(Locale locale) throws MalformedURLException {
        File file = new File("src/main/resources");
        URL[] urls = {file.toURI().toURL()};
        ClassLoader loader = new URLClassLoader(urls);
        bundle = ResourceBundle.getBundle("prop", locale, loader);
    }

    public String getAnswer(String key){
        return bundle.getString(key);
    }

    public String getQuestions(){
        return bundle.getString("0");
    }
}
