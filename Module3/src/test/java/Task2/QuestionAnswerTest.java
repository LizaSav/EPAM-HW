package Task2;

import org.junit.Test;
import java.net.MalformedURLException;
import java.util.Locale;

import static org.junit.Assert.assertEquals;

/**
 * Created by Elizaveta on 03.04.2016.
 */
public class QuestionAnswerTest {
    @Test
    public void getQuestionsTest() throws MalformedURLException {
        Locale locale =new Locale("ru");
        QuestionAnswer qa = new QuestionAnswer(locale);
        System.out.println(qa.getQuestions());
    }

    @Test
    public void getAnswerTest() throws MalformedURLException {
        assertEquals("Москва", (new QuestionAnswer(new Locale("ru")).getAnswer("1")));
        assertEquals("London", (new QuestionAnswer(new Locale("en")).getAnswer("2")));
    }
}
