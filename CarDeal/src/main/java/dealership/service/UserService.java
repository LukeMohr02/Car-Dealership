package dealership.service;

import dealership.database.DAOFactory;
import dealership.database.GenericDAO;
import dealership.database.UserDAO;
import dealership.model.User;

// This class fills in for a database
// TOO MANY THINGS ARE STATIC
public class UserService {

    public static boolean usernameExists(String username) {

        /*if (username == null) {
            return false;
        }

        for (User u : users) {

            if (u != null) {
                if (username != null && u.getUsername().equals(username)) {
                    return true;
                }
            }
        }
        */
        return false;
    }

    public User createUser(String username, String password, String userType) {
        return new User(username, password, userType);
    }

    public void addUser(User u) throws IllegalAccessException {
        GenericDAO dao = DAOFactory.getDAO(User.class);
        dao.insert(u);
    }

    public User getUser(String username) throws IllegalAccessException {
        GenericDAO dao = DAOFactory.getDAO(User.class);
        return (User) dao.get(username);
    }
}
