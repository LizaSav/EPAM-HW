package Task2.DAO;

import Task2.ConnectionPool.ConnectionPool;
import Task2.model.Book;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashSet;
import java.util.Optional;

/**
 * Created by Elizaveta on 21.04.2016.
 */
public class BookDAO extends LibraryDAO {

    public static Optional<Book> getBookByID(int id) {
        try (final ConnectionPool connectionPool = ConnectionPool.create(RESOURCES_FILE_PATH + DB_PROPERTIES_FILE_NAME);
             Statement st = connectionPool.getConnection().createStatement(); ResultSet rs = st.executeQuery("SELECT *FROM Book WHERE id=" + id)) {
            return rs.next()
                    ? Optional.of(new Book(id,
                    rs.getString("title"),
                    AuthorDAO.getAuthorByID(rs.getInt("author_ID")).orElseThrow(RuntimeException::new),
                    rs.getInt("year"),
                    rs.getString("format").charAt(0)))
                    : Optional.empty();
        } catch (Exception e) {
            throw new RuntimeException("ConectionPoolException", e);
        }
    }

    public static Optional<HashSet<Book>> getBooksByAuthor(String firstname, String lastname) {
        try (final ConnectionPool connectionPool = ConnectionPool.create(RESOURCES_FILE_PATH + DB_PROPERTIES_FILE_NAME);
             Statement st = connectionPool.getConnection().createStatement()) {
            int id = AuthorDAO.getIdByName(firstname, lastname).orElse(0);
            if (id == 0) return Optional.empty();
            HashSet<Book> books = new HashSet<>();
            try (ResultSet rs = st.executeQuery("SELECT *FROM Book WHERE author_ID=" + id)) {
                while (rs.next()) {
                    books.add(new Book(rs.getInt("id"),
                            rs.getString("title"),
                            AuthorDAO.getAuthorByID(rs.getInt("author_ID")).orElseThrow(RuntimeException::new),
                            rs.getInt("year"),
                            rs.getString("format").charAt(0)));
                }
                return Optional.of(books);
            }
        } catch (Exception e) {
            throw new RuntimeException("ConectionPoolException", e);
        }
    }

    public static void addBook(String title, String firstname, String lastname, int year, char format) {

        int id = AuthorDAO.getIdByName(firstname, lastname).orElse(0);
        if (id == 0) {
            id = AuthorDAO.addAuthor(firstname, lastname);
        }
        try (final ConnectionPool connectionPool = ConnectionPool.create(RESOURCES_FILE_PATH + DB_PROPERTIES_FILE_NAME);
             Statement st = connectionPool.getConnection().createStatement()) {
            st.executeUpdate("INSERT INTO  Book (title, author_ID, year, format ) VALUES ('" + title + "', " + id + ", " + year + ", '" + format + "')");
        } catch (SQLException e) {
            throw new RuntimeException("SQL Exception", e);
        } catch (Exception e) {
            throw new RuntimeException("ConectionPool Exception", e);
        }
    }

    public static Optional<HashSet<Book>> getBookByTitle(String title) {
        try (final ConnectionPool connectionPool = ConnectionPool.create(RESOURCES_FILE_PATH + DB_PROPERTIES_FILE_NAME);
             Statement st = connectionPool.getConnection().createStatement();
             ResultSet rs = st.executeQuery("SELECT *FROM Book WHERE title='" + title + "'")) {
            HashSet<Book> books = new HashSet<>();
            while (rs.next()) {
                books.add(new Book(rs.getInt("id"),
                        title,
                        AuthorDAO.getAuthorByID(rs.getInt("author_ID")).orElseThrow(RuntimeException::new),
                        rs.getInt("year"),
                        rs.getString("format").charAt(0)));
            }
            return Optional.of(books);
        } catch (Exception e) {
            throw new RuntimeException("ConectionPoolException", e);
        }
    }

    public static Optional<HashSet<Book>> getAllBooks() {
        try (final ConnectionPool connectionPool = ConnectionPool.create(RESOURCES_FILE_PATH + DB_PROPERTIES_FILE_NAME);
             Statement st = connectionPool.getConnection().createStatement(); ResultSet rs = st.executeQuery("SELECT *FROM Book")) {
            HashSet<Book> books = new HashSet<>();
            while (rs.next()) {
                books.add(new Book(rs.getInt("id"),
                        rs.getString("title"),
                        AuthorDAO.getAuthorByID(rs.getInt("author_ID")).orElseThrow(RuntimeException::new),
                        rs.getInt("year"),
                        rs.getString("format").charAt(0)));
            }
            return Optional.of(books);
        } catch (Exception e) {
            throw new RuntimeException("ConectionPoolException", e);
        }
    }

    public static void deleteBookByID(int id) {
        try (final ConnectionPool connectionPool = ConnectionPool.create(RESOURCES_FILE_PATH + DB_PROPERTIES_FILE_NAME);
             Statement st = connectionPool.getConnection().createStatement();
             ResultSet rs = st.executeQuery("SELECT (author_ID) FROM Book WHERE id=" + id)) {

            int authorID = 0;
            while (rs.next()) {
                authorID = rs.getInt("author_ID");
            }
            assert authorID != 0;
            ResultSet rs1 = st.executeQuery("SELECT (id) FROM Book WHERE author_ID=" + authorID);
            int i = 0;
            while (rs1.next()) {
                i++;
            }
            rs1.close();
            st.addBatch("DELETE FROM Book WHERE id=" + id);
            if (i == 1) {
                st.addBatch("DELETE FROM Author WHERE id=" + authorID);
            }
            st.executeBatch();

        } catch (SQLException e) {
            throw new RuntimeException("SQL Exception", e);
        } catch (Exception e) {
            throw new RuntimeException("ConectionPool Exception", e);
        }
    }


}

