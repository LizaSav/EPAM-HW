package Task2.model;

/**
 * Created by Elizaveta on 21.04.2016.
 */
public class Author {
    private int id;
    private String firstName;
    private String lastName;

    public Author(int id, String firstName, String lastName) {
        this.id = id;
        this.firstName = firstName;

        this.lastName = lastName;
    }

    @Override
    public String toString() {
        return "Author{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Author author = (Author) o;

        return id == author.id;

    }

    @Override
    public int hashCode() {
        return id;
    }


}
