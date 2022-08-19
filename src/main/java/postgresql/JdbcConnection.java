package postgresql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;

public class JdbcConnection {

    private static final Logger LOGGER =
        Logger.getLogger(JdbcConnection.class.getName());
    //todo: remove optional pattern, I actually find it annoying and unnecessary
    private static Optional<Connection> connection = Optional.empty();

    public static Optional<Connection> getConnection() {
        if (connection.isEmpty()) { //todo:hide credentials
            String url = "jdbc:postgresql://localhost:5432/sampleDB";
            String user = "postgres";
            String password = "root";

            try {
                connection = Optional.ofNullable(
                    DriverManager.getConnection(url, user, password));
            } catch (SQLException ex) {
                LOGGER.log(Level.SEVERE, null, ex);
            }
        }

        return connection;
    }
}
