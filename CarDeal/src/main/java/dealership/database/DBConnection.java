package dealership.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {

    private static DBConnection instance;

    public Connection getConnection() throws SQLException {
        //jdbc:postgresql://<aws endpoint>:<port>/<database>
        //  Optional select schema: ?currentSchema=<schema name>
        //      Anything after ? is a parameter
        //TODO: CHANGE ROOT LOGIN INFO
        return DriverManager.getConnection("jdbc:postgresql://car-dealership.csf1elrfwgmr.us-west-1.rds.amazonaws.com:5432/postgres", "postgres", "Lm052701");
    }
}
