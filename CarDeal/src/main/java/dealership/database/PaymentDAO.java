package dealership.database;

import dealership.model.Payment;

import java.sql.SQLException;
import java.sql.Statement;

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
    public void insert(Payment p) {
        try {
            String sql = "insert into users (\"car_make\", \"car_model\", \"car_year\", \"car_color\", \"car_owner\") values ('"+
                    p.getUserId() + "', '" +
                    p.getCarId()  + "', '" +
                    p.getAmount() + "');";

            Statement st = new ConnectionSingleton().getConnection().createStatement();

            // Used to manipulate database, not query
            int i = st.executeUpdate(sql);
            System.out.println("Number of updated rows: " + i);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Payment get(Integer id) {
        return null;
    }

    @Override
    public Payment[] getAll() {
        return new Payment[0];
    }

    @Override
    public void delete(Integer id) {
        try {
            String sql = "delete from payments where \"car_id\" = '" +
                    id + "';";

            Statement st = new ConnectionSingleton().getConnection().createStatement();

            // Used to manipulate database, not query
            int i = st.executeUpdate(sql);
            System.out.println("Number of updated rows: " + i);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void update(Payment p) {

    }
}
