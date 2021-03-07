package dealership;

import dealership.database.ConnectionSingleton;
import dealership.ui.WelcomeMenu;

import java.sql.SQLException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws SQLException {

        Scanner scan = new Scanner(System.in);

        WelcomeMenu welcome = new WelcomeMenu(scan);

        try {
            ConnectionSingleton.getInstance();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        welcome.showUi();

        scan.close();
    }        
}
