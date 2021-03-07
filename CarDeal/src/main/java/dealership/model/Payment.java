package dealership.model;

public class Payment {
    String userId;
    int    carId;
    String amount;

    public Payment() {

    }

    public Payment(String userId, int carId, String amount) {
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

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }
}
