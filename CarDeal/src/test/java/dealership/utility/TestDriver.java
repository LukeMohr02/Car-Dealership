package dealership.utility;

import dealership.database.*;
import dealership.model.User;
import dealership.service.UserService;
import dealership.ui.WelcomeMenu;

import java.sql.SQLException;
import java.util.Scanner;

public class TestDriver {
    public static void main(String[] args) throws SQLException, IllegalAccessException {

        Scanner scan = new Scanner(System.in);

        WelcomeMenu welcome = new WelcomeMenu(scan);

        try {
            ConnectionSingleton.getInstance();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        //welcome.showUi(scan);

        UserService us = new UserService();

        //us.addUser(us.createUser("Fred","123","customer"));
//        us.removeUser("Fred");
//        User[] users = us.getAllUsers();
//
//        for (User i : users) {
//            System.out.println(i.getUsername() + " " + i.getPassword() + " " + i.getUserType());
//        }

        UserDAO dao = new UserDAO();
        dao.update("bob","user_username", "Billy");

        scan.close();
    }        
}
