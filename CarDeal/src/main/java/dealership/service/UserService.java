package dealership.service;

import dealership.database.DAOFactory;
import dealership.database.GenericDAO;
import dealership.model.User;

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

    public void addUser(User user) throws IllegalAccessException {
        dao.insert(user);
    }

    public User getUser(String username) throws IllegalAccessException {
        if (usernameExists(username)) {
            return (User) dao.get(username);
        }
        return null;
    }

    public User[] getAllUsers() {
        return (User[]) dao.getAll();
    }

    public void updateUser(String username, String columnName, String value) {
        dao.update(columnName, value, username);
    }

    public void removeUser(String username) {
        dao.delete(username);
    }
}
