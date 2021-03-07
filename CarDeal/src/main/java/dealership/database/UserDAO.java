package dealership.database;

import dealership.model.User;

import javax.xml.transform.Result;
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
            PreparedStatement ps = new ConnectionSingleton().getConnection().prepareStatement("insert into users values (?, ?, ?)");
            ps.setString(1, u.getUsername());
            ps.setString(2, u.getPassword());
            ps.setString(3, u.getUserType());

            // Used to manipulate database, not query
            int i = ps.executeUpdate();
            System.out.println("Number of updated rows: " + i);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public User get(String username) {
        try {
            PreparedStatement ps = new ConnectionSingleton().getConnection().prepareStatement("select * from users where user_username = ?;");
            ps.setString(1, username);
            ResultSet rs = ps.executeQuery();

            rs.next();

            User user = new User();
            user.setUsername(rs.getString("user_username"));
            user.setPassword(rs.getString("user_password"));
            user.setUserType(rs.getString("user_type"));

            return user;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public User[] getAll() {
        try {
            PreparedStatement ps = new ConnectionSingleton().getConnection().prepareStatement("select * from users", ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ResultSet rs = ps.executeQuery();

            rs.last();
            User[] users = new User[rs.getRow()];
            rs.beforeFirst();

            while (rs.next()) {
                User user = new User();
                user.setUsername(rs.getString("user_username"));
                user.setPassword(rs.getString("user_password"));
                user.setUserType(rs.getString("user_type"));
                users[rs.getRow() - 1] = user;
            }

            return users;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void update(String username, String columnName, String value) {
        try {
            PreparedStatement ps = new ConnectionSingleton().getConnection().prepareStatement("update users set user_type = ? where \"user_username\" = ?");
            //ps.setString(1, "user_type");
            ps.setString(1, value);
            ps.setString(2, username);

            // Used to manipulate database, not query
            int i = ps.executeUpdate();
            System.out.println("Number of updated rows: " + i);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(String id) {
        try {
            PreparedStatement ps = new ConnectionSingleton().getConnection().prepareStatement("delete from users where \"user_username\" = ?;");
            ps.setString(1, id);

            int i = ps.executeUpdate();
            System.out.println("Number of updated rows: " + i);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
