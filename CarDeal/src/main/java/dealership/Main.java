package dealership;

import dealership.ui.WelcomeMenu;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        WelcomeMenu welcome = new WelcomeMenu();

        welcome.showUi(scan);

        scan.close();
    }        
}
