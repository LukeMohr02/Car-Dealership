package dealership.utility;

import dealership.database.ConnectionSingleton;
import dealership.ui.WelcomeMenu;

import java.sql.SQLException;
import java.util.Scanner;

public class TestDriver {
    public static void main(String[] args) throws SQLException {

        Scanner scan = new Scanner(System.in);

        WelcomeMenu welcome = new WelcomeMenu();

        try {
            ConnectionSingleton.getInstance();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        welcome.showUi(scan);

        scan.close();
    }        
}
