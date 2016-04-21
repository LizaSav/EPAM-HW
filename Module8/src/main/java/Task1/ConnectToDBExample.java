package Task1;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.*;
import java.util.stream.Collectors;

/**
 * Created by Elizaveta on 18.04.2016.
 */

public class ConnectToDBExample {

    public static final String PATH = "src/main/resources/h2.sql";

    public static void init() throws ClassNotFoundException, IOException, SQLException {
        Class.forName("org.h2.Driver");
        final Path path = Paths.get(PATH);
        final String[] sqls = Files.lines(path)
                .collect(Collectors.joining()).split(";");
        try (Connection connection = DriverManager.getConnection("jdbc:h2:mem:test;DB_CLOSE_DELAY=-1");
             Statement statement = connection.createStatement()) {
            for (String  sql: sqls) {
                statement.addBatch(sql);
            }
            statement.executeBatch();
        }
    }


    public static void main(String[] args) throws SQLException, IOException, ClassNotFoundException {
        init();
        try (Connection connection = DriverManager.getConnection("jdbc:h2:mem:test;DB_CLOSE_DELAY=-1");
             Statement statement = connection.createStatement()) {
            statement.executeUpdate("INSERT INTO Author (first_name, last_name) VALUES ('1Michael', 'Bulgakov') ");
            try (ResultSet rs = statement.executeQuery("SELECT * FROM Author WHERE  id='4'")) {
                while (rs.next()) {
                    System.out.println(rs.getInt("id") + " " + rs.getString("first_name") + " " + rs.getString("last_name") + "\n");
                }
            }

            statement.addBatch("UPDATE Author set first_name='Michael' WHERE id='4'");
            statement.addBatch("UPDATE Book set format='s' WHERE format='S'");
            statement.addBatch("UPDATE Book set format='m' WHERE format='M'");
            statement.addBatch("UPDATE Book set format='l' WHERE format='L'");
            statement.executeBatch();
            try (ResultSet rs = statement.executeQuery("SELECT *  FROM Author")) {
                while (rs.next())
                    System.out.println(rs.getInt("id") + " " + rs.getString("first_name") + " " + rs.getString("last_name"));
            }
            statement.executeUpdate("DROP TABLE ForRemoving");

        }

    }
}
