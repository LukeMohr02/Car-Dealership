package dealership.service;

import dealership.database.DAOFactory;
import dealership.database.GenericDAO;
import dealership.database.UserDAO;
import dealership.model.User;

// TOO MANY THINGS ARE STATIC
// TODO: convert this to a generic service
public class UserService {

    GenericDAO dao;

    public UserService() {
        try {
            dao = DAOFactory.getDAO(User.class);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    public boolean usernameExists(String username) {

        User[] users = getAllUsers();

        for (User u : users) {
            if (u.getUsername().equals(username)) {
                return true;
            }
        }

        return false;
    }

    public User createUser(String username, String password, String userType) {
        return new User(username, password, userType);
    }

    public void addUser(User u) throws IllegalAccessException {
        dao.insert(u);
    }

    public User getUser(String username) throws IllegalAccessException {
        return (User) dao.get(username);
    }

    public User[] getAllUsers() {
        return (User[]) dao.getAll();
    }

    public void updateUser(String username, String columnName, String value) {
        dao.update(username, columnName, value);
    }

    public void removeUser(String username) {
        dao.delete(username);
    }
}
