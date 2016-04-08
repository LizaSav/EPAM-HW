package Task4;

import java.io.*;
import java.util.HashMap;

/**
 * Created by Elizaveta on 08.04.2016.
 */
public class FilmsCollection implements Serializable {
    private HashMap<String, Film> collection;
    transient private int numberoffilms;

    @Override
    public String toString() {
        return "FilmsCollection{" +
                "collection=" + collection +
                '}';
    }

    public FilmsCollection() {
        collection = new HashMap<>();
    }

    public int getNumberoffilms() {
        return numberoffilms;
    }

    public Film getFilm(String title) {
        return collection.get(title);
    }

    public FilmsCollection numberOfFilmsInit() {
        numberoffilms = collection.size();
        return this;
    }

    public FilmsCollection addFilm(Film film) {
        collection.put(film.getTitle(), film);
        numberoffilms++;
        return this;
    }

    public FilmsCollection removeFilm(String title) {
        collection.remove(title);
        numberoffilms--;
        return this;
    }

    public void save() {
        try (FileOutputStream os = new FileOutputStream("src/main/resources/filmscollection"); ObjectOutputStream oos = new ObjectOutputStream(os)) {
            oos.writeObject(this);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static FilmsCollection download() throws ClassNotFoundException, IOException {
        try (FileInputStream is = new FileInputStream("src/main/resources/filmscollection"); ObjectInputStream ois = new ObjectInputStream(is);) {
            return ((FilmsCollection) ois.readObject()).numberOfFilmsInit();
        }
    }
}
