package Task2.model;

/**
 * Created by Elizaveta on 21.04.2016.
 */
public class Book {
    private int id;
    private String title;
    private Author author;
    private int year;
    private char format;

    public Book(int id, String title, Author author, int year, char format) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.year = year;
        this.format = format;
    }

    @Override
    public String toString() {
        return "Book{" +
                "title='" + title + '\'' +
                ", author=" + author +
                ", year=" + year +
                ", format=" + format +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Book book = (Book) o;

        return id == book.id;

    }

    @Override
    public int hashCode() {
        return id;
    }


}
