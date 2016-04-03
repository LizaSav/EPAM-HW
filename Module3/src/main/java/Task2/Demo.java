package Task2;

import java.net.MalformedURLException;
import java.util.Locale;
import java.util.Scanner;

/**
 * Created by Elizaveta on 03.04.2016.
 */
public class Demo {
    public static void main(String[] args) throws MalformedURLException {
        System.out.println("Выберите язык ru/ Choose the language en");
        Scanner scanner = new Scanner(System.in);
        String s=scanner.nextLine();
        Locale locale=new Locale(s);
        QuestionAnswer qa=new QuestionAnswer(locale);
        System.out.println(qa.getQuestions());
        System.out.println(qa.getAnswer(scanner.nextLine()));
    }
}
