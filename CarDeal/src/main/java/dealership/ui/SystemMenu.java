package dealership.ui;


import dealership.model.User;

import java.util.Scanner;

public class SystemMenu {
    User user;
    Scanner scan;

    public SystemMenu(User user, Scanner scan) {
        this.user = user;
        this.scan = scan;
    }

    public int rejectOffersUi() {
        System.out.println("Please enter the ID of the car to reject all offers:");
        return scan.nextInt();

    }
}
