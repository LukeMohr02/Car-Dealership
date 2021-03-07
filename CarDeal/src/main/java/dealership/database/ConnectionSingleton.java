package dealership.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

// Has extra functionality in addition to factory
public class ConnectionSingleton {

    private static ConnectionSingleton instance;
    private static Connection connection;

    public static ConnectionSingleton getInstance() throws SQLException {
        if (instance == null) {
            instance = new ConnectionSingleton();
        }
        return instance;
    }

    public ConnectionSingleton() throws SQLException {
        //jdbc:postgresql://<aws endpoint>:<port>/<database>
        //  Optional select schema: ?currentSchema=<schema name>
        //      Anything after ? is a parameter
        connection = DriverManager.getConnection("jdbc:postgresql://car-dealership.csf1elrfwgmr.us-west-1.rds.amazonaws.com:5432/postgres", "lukemohr", "4815162342");
    }

    public Connection getConnection() {
        return connection;
    }

    public void closeConnection() throws SQLException {
        connection.close();
    }

}
