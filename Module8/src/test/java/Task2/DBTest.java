package Task2;

import Task2.ConnectionPool.ExceptionalConsumer;
import org.junit.BeforeClass;
import org.junit.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Arrays;
import java.util.stream.Collectors;

import static Task2.DAO.AuthorDAO.*;
import static Task2.DAO.BookDAO.*;

/**
 * Created by Elizaveta on 21.04.2016.
 */
public class DBTest {
    @SuppressWarnings("InjectedReferences")
    private static final String RESOURCES_FILE_PATH = "src/main/resources/";
    @SuppressWarnings("InjectedReferences")
    private static final String DB_PROPERTIES_FILE_NAME = "db.properties";
    private static final String DB_PREPARE_FILE_NAME = "h2.sql";

    @BeforeClass
    public static void init() throws ClassNotFoundException, SQLException, IOException {
        Class.forName("org.h2.Driver");
        final Path path = Paths.get(RESOURCES_FILE_PATH, DB_PREPARE_FILE_NAME);
        final String[] sqls = Files.lines(path)
                .collect(Collectors.joining()).split(";");
        try (Connection connection = DriverManager.getConnection("jdbc:h2:mem:test;DB_CLOSE_DELAY=-1");
             Statement statement = connection.createStatement()) {
            Arrays.stream(sqls).forEach((ExceptionalConsumer<String, ?>) statement::addBatch);
            statement.executeBatch();
        }
    }

//    @Test
//    public void simpleTestDB() throws Exception {
//        try (Connection connection = DriverManager.getConnection("jdbc:h2:mem:test;DB_CLOSE_DELAY=-1");
//             Statement statement = connection.createStatement()) {
//            testDb(statement);
//        }
//    }
//
//    @Test
//    public void cpTest() throws Exception {
//        try (final ConnectionPool connectionPool = ConnectionPool.create(RESOURCES_FILE_PATH + DB_PROPERTIES_FILE_NAME);
//             final Connection connection = connectionPool.getConnection();
//             final Statement statement = connection.createStatement()) {
//            testDb(statement);
//        }
//    }
//
//    private void testDb(Statement statement) throws SQLException {
//        try (ResultSet rs = statement.executeQuery("SELECT id, first_name FROM Author")) {
//            while (rs.next())
//                System.out.println(rs.getInt("id") + " " + rs.getString("first_name"));
//        }
//    }

    @Test
    public void DAOTest(){
        System.out.println(getAuthorByID(1));
        System.out.println();
        addBook("U", "Erlend","Lu", 2007,'L');

        System.out.println();
        addBook("1", "name", "name", 1400, 'S');
        System.out.println(getAuthorByID(4));
        //удалить эту книгу
        System.out.println(getBooksByAuthor("Erlend", "Lu"));
        System.out.println();
        System.out.println(getAllBooks());
        System.out.println();
        deleteBookByID(5);
        deleteBookByID(4);
        System.out.println(getAllBooks());
        System.out.println(getAllAuthors());

    }
}

