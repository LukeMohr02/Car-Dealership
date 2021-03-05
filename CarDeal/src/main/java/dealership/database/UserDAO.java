package dealership.database;

import dealership.model.User;

import java.sql.*;

// Java Database Connectivity
public class UserDAO implements GenericDAO<User, String> {

    private static UserDAO instance;

    public UserDAO() {
    }

    static UserDAO getInstance() {
        if (instance == null) {
            instance = new UserDAO();
        }
        return instance;
    }

    @Override
    public void insert(User u) {
        try {
            String sql = "insert into users values ('"+
                    u.getUsername() + "', '" +
                    u.getPassword() + "', '" +
                    u.getUserType() + "');";

            Statement st = new DBConnection().getConnection().createStatement();

            // Used to manipulate database, not query
            int i = st.executeUpdate(sql);
            System.out.println("Number of updated rows: " + i);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public User get(String username) {
        return null;
    }

    @Override
    public User[] getAll() {
        return new User[0];
    }

    @Override
    public void remove(String id) {
        try {
            String sql = "delete from users where \"user_username\" = '" +
                    id + "';";

            Statement st = new DBConnection().getConnection().createStatement();

            // Used to manipulate database, not query
            int i = st.executeUpdate(sql);
            System.out.println("Number of updated rows: " + i);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
