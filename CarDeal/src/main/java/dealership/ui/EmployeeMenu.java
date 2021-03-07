package dealership.ui;

import dealership.model.Car;

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
        car.setMake(scan.nextLine());
        System.out.println("Enter car year: ");
        car.setMake(scan.nextLine());
        System.out.println("Enter car color: ");
        car.setMake(scan.nextLine());

        return car;
    }
}
