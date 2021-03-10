package dealership.model;

public class Offer {
    String userId;
    int    carId;
    double amount;

    public Offer() {

    }

    public Offer(String userId, int carId, double amount) {
        this.userId = userId;
        this.carId = carId;
        this.amount = amount;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public int getCarId() {
        return carId;
    }

    public void setCarId(int carId) {
        this.carId = carId;
    }

    public double getAmount() { return amount; }

    public void setAmount(double amount) { this.amount = amount; }
}
