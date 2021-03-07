package dealership.model;

public class Car {

    private int id;
    private String make;
    private String model;
    private int year;
    private String color;
    private User owner;

    public Car() {

    }

    public Car(String make, String model, int year, String color, User owner) {
        this.make = make;
        this.model = model;
        this.year = year;
        this.color = color;
        this.owner = owner;
    }

    public String getMake() {
        return make;
    }

    public int getId() { return id; }

    public void setId(int id) { this.id = id; }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public User getOwner() {
        return owner;
    }

    public void setOwner(User owner) {
        this.owner = owner;
    }
}
