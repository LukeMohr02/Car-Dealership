package dealership.service;

import dealership.model.User;

import java.util.Scanner;

public class GeneralService {
    User user;
    Scanner scan;

    GeneralService() {

    }

    GeneralService (User user, Scanner scan) {
        this.user = user;
        this.scan = scan;
    }

    void signOut() {
        user.setLoggedIn(false);
    }
}
