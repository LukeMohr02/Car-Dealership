package dealership.service;

import dealership.model.User;

public class GeneralService {
    User user;

    GeneralService() {

    }

    GeneralService (User user) {
        this.user = user;
    }

    void signOut() {
        user.setLoggedIn(false);
    }
}
