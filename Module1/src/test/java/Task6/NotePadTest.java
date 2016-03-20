package Task6;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
/**
 * Created by Elizaveta on 20.03.2016.
 */
public class NotePadTest {
    NotePad n;
    @Test
    public void deleteNoteTest(){
        System.out.println("Удаление записи second");
        assertEquals(n.deleteNote("second").getText(), "2lalala");
        n.printNotePad();
//        n.addNote("first", "blabla");
//        n.deleteNote("first");
    }

    @Test
    public void editNoteTest(){
        System.out.println("Редактирование записи first");
        assertEquals(n.editNote("first", "new text").getText(),"new text");
        n.printNotePad();
    }

    @Before
    public void printNotePadTest(){
        n=new NotePad();
        n.addNote("first", "1blablabla");
        n.addNote("second", "2lalala");
        n.addNote("third", "3bebebe");
        System.out.println("Начальный список записей");
        n.printNotePad();
    }
}
