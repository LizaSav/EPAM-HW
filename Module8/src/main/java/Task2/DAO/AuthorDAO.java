package Task2.DAO;

import Task2.ConnectionPool.ConnectionPool;
import Task2.model.Author;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.HashSet;
import java.util.Optional;

/**
 * Created by Elizaveta on 21.04.2016.
 */

public class AuthorDAO extends LibraryDAO {
    public static Optional<Author> getAuthorByID(int id) {
        try (final ConnectionPool connectionPool = ConnectionPool.create(RESOURCES_FILE_PATH + DB_PROPERTIES_FILE_NAME);
             Statement st = connectionPool.getConnection().createStatement(); ResultSet rs = st.executeQuery("SELECT *FROM Author WHERE id=" + id)) {
            return rs.next()
                    ? Optional.of(new Author(id,
                    rs.getString("first_name"),
                    rs.getString("last_name")))
                    : Optional.empty();
        } catch (Exception e) {
            throw new RuntimeException("ConectionPoolException", e);
        }
    }

    public static Optional<Integer> getIdByName(String firstname, String lastname) {
        try (final ConnectionPool connectionPool = ConnectionPool.create(RESOURCES_FILE_PATH + DB_PROPERTIES_FILE_NAME);
             Statement st = connectionPool.getConnection().createStatement();
             ResultSet rs = st.executeQuery("SELECT (id) FROM Author WHERE first_name='" + firstname + "' and last_name='" + lastname + "'")) {
            return rs.next()
                    ? Optional.of(rs.getInt("id"))
                    : Optional.empty();
        } catch (Exception e) {
            throw new RuntimeException("ConectionPoolException", e);
        }
    }

    public static int addAuthor(String firstname, String lastname) {
        int id = AuthorDAO.getIdByName(firstname, lastname).orElse(0);
        if (id == 0) {
            try (final ConnectionPool connectionPool = ConnectionPool.create(RESOURCES_FILE_PATH + DB_PROPERTIES_FILE_NAME);
                 Statement st = connectionPool.getConnection().createStatement()) {
                st.executeUpdate("INSERT INTO Author (first_name,last_name) VALUES ('" + firstname + "', '" + lastname + "')");
                try (ResultSet rs = st.executeQuery("SELECT (id)FROM Author WHERE first_name='" + firstname + "' and  last_name='" + lastname + "'")) {
                    rs.next();
                    return rs.getInt("id");
                }
            } catch (Exception e) {
                throw new RuntimeException("ConectionPoolException", e);
            }
        } else {
            throw new RuntimeException(firstname + " " + lastname + " already exist");
        }

    }

    public static Optional<HashSet<Author>> getAllAuthors() {
        try (final ConnectionPool connectionPool = ConnectionPool.create(RESOURCES_FILE_PATH + DB_PROPERTIES_FILE_NAME);
             Statement st = connectionPool.getConnection().createStatement(); ResultSet rs = st.executeQuery("SELECT *FROM Author")) {
            HashSet<Author> authors = new HashSet<>();
            while (rs.next()) {
                authors.add(new Author(rs.getInt("id"),
                        rs.getString("first_name"),
                        rs.getString("last_name")));
            }
            return Optional.of(authors);
        } catch (Exception e) {
            throw new RuntimeException("ConectionPoolException", e);
        }

    }
}
