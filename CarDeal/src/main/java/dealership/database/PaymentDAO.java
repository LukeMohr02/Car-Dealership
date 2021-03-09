package dealership.database;

import dealership.model.Payment;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

// Java Database Connectivity
public class PaymentDAO implements GenericDAO<Payment, Integer> {

    private static PaymentDAO instance;

    public PaymentDAO() {
    }

    static PaymentDAO getInstance() {
        if (instance == null) {
            instance = new PaymentDAO();
        }
        return instance;
    }

    @Override
    public void insert(Payment payment) {
        try {
            PreparedStatement ps = new ConnectionSingleton().getConnection().prepareStatement("insert into payments values (?, ?, ?)");
            ps.setString(1, payment.getUserId());
            ps.setInt   (2, payment.getCarId());
            ps.setDouble(3, payment.getAmount());

            // Used to manipulate database, not query
            int i = ps.executeUpdate();
            System.out.println("Number of updated rows: " + i);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Payment get(Integer car_id) {
        try {
            PreparedStatement ps = new ConnectionSingleton().getConnection().prepareStatement("select * from payments where car_id = ?;");
            ps.setInt(1, car_id);
            ResultSet rs = ps.executeQuery();

            rs.next();

            Payment payment = new Payment();
            payment.setCarId (rs.getInt   ("car_id"));
            payment.setUserId(rs.getString("user_id"));
            payment.setAmount(rs.getDouble("payment_amount"));

            return payment;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Payment[] getAll() {
        try {
            PreparedStatement ps = new ConnectionSingleton().getConnection().prepareStatement("select * from payments", ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ResultSet rs = ps.executeQuery();

            rs.last();
            Payment[] payments = new Payment[rs.getRow()];
            rs.beforeFirst();

            while (rs.next()) {
                Payment payment = new Payment();
                payment.setCarId (rs.getInt   ("car_id"));
                payment.setUserId(rs.getString("user_id"));
                payment.setAmount(rs.getDouble("payment_amount"));
                payments[rs.getRow() - 1] = payment;
            }

            return payments;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void update(Integer id, String columnName, String value) {
        try {
            PreparedStatement ps = new ConnectionSingleton().getConnection().prepareStatement("update payments set " + columnName + " = ? where \"car_id\" like ?");
            ps.setString(1, value);
            ps.setInt   (2, id);

            // Used to manipulate database, not query
            int i = ps.executeUpdate();
            System.out.println("Number of updated rows: " + i);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(Integer car_id) {
        try {
            PreparedStatement ps = new ConnectionSingleton().getConnection().prepareStatement("delete from payments where \"car_id\" like ?;");
            ps.setInt(1, car_id);

            int i = ps.executeUpdate();
            System.out.println("Number of updated rows: " + i);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void callFunction() {

    }
}
