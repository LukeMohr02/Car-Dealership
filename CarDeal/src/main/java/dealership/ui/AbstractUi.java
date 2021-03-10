package dealership.ui;

import dealership.service.UserService;

import java.util.Scanner;

public abstract class AbstractUi {
    Scanner scan;

    public AbstractUi(Scanner scan) {
        this.scan = scan;
    }

    public abstract void showUi();

}
