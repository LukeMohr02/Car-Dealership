package dealership.ui;

import dealership.model.Car;
import dealership.service.GeneralService;

import java.util.Scanner;

public class EmployeeMenu {
    Scanner scan;

    public EmployeeMenu(Scanner scan) {
        this.scan = scan;
    }

    public Car addCarUi() {
        Car car = new Car();

        System.out.println("Enter car make: ");
        car.setMake(scan.nextLine());
        System.out.println("Enter car model: ");
        car.setModel(scan.nextLine());
        System.out.println("Enter car year: ");
        car.setYear(scan.nextInt());
        scan.nextLine();
        System.out.println("Enter car color: ");
        car.setColor(scan.nextLine());
        car.setOwner(null);

        return car;
    }

    public int removeCarUi(GeneralService gs) {
        gs.viewLot();
        System.out.println("Please enter the ID of the car you would like to remove:");

        //TODO: validate input
        int userInput = scan.nextInt();

        System.out.println("Removing ID " + userInput + " from the lot...\n");

        return userInput;
    }
}
