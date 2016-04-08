package Task4;

import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.assertTrue;

/**
 * Created by Elizaveta on 08.04.2016.
 */
public class FilmsCollectionTest {
//    @Test
//    public void saveTest(){
//        FilmsCollection films = new FilmsCollection();
//        Actor a=new Actor("a","a");
//        Actor b=new Actor("b","b");
//        Actor c=new Actor("c","c");
//        Actor d=new Actor("d","d");
//        Film film1=new Film("1film");
//        film1.addActor(a).addActor(b);
//        Film film2 = new Film("2film");
//        film2.addActor(a).addActor(c);
//        Film film3 = new Film("3film");
//        film3.addActor(d).addActor(c);
//        films.addFilm(film1).addFilm(film2).addFilm(film3);
//        films.save();
//    }
//    @Test
//    public  void downloadTest() throws IOException, ClassNotFoundException {
//        FilmsCollection films =FilmsCollection.download();
//        assertTrue(films.getNumberoffilms()==3);
//    }
    @Test
    public  void addTest() throws IOException, ClassNotFoundException {
        FilmsCollection films =FilmsCollection.download();
        films.addFilm(new Film("4film").addActor(new Actor("f","f")));
        films.save();
        films =FilmsCollection.download();
        assertTrue(films.getNumberoffilms()==4);
        films.removeFilm("4film");
        films.save();
        films =FilmsCollection.download();
        assertTrue(films.getNumberoffilms()==3);
    }
}
