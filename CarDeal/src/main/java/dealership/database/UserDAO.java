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
            PreparedStatement ps = new ConnectionSingleton().getConnection().prepareStatement("insert into membership_type values (?, ?, ?,)");
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
            PreparedStatement ps = new ConnectionSingleton().getConnection().prepareStatement("select * from users where user_username = ?");
            ps.setString(1, username);
            ResultSet rs = ps.executeQuery();

            rs.next();
            return (User) rs.getObject("user_username");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public User[] getAll() {
        return new User[0];
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

    public void update(User u) {

    }
}
