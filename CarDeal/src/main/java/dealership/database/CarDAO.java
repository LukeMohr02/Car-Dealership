package dealership.database;

import dealership.model.Car;
import dealership.model.User;

import java.sql.SQLException;
import java.sql.Statement;

// Java Database Connectivity
public class CarDAO implements GenericDAO<Car, Integer> {

    private static CarDAO instance;

    public CarDAO() {
    }

    static CarDAO getInstance() {
        if (instance == null) {
            instance = new CarDAO();
        }
        return instance;
    }

    @Override
    public void insert(Car c) {
        try {
            String sql = "insert into users (\"car_make\", \"car_model\", \"car_year\", \"car_color\", \"car_owner\") values ('"+
                    c.getMake()  + "', '" +
                    c.getModel() + "', '" +
                    c.getYear()  + "', '" +
                    c.getColor() + "', '" +
                    c.getOwner() + "');";

            Statement st = new DBConnection().getConnection().createStatement();

            // Used to manipulate database, not query
            int i = st.executeUpdate(sql);
            System.out.println("Number of updated rows: " + i);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Car get(Integer id) {
        return null;
    }

    @Override
    public Car[] getAll() {
        return new Car[0];
    }

    @Override
    public void remove(Integer id) {
        try {
            String sql = "delete from users where \"id\" = '" +
                    id + "';";

            Statement st = new DBConnection().getConnection().createStatement();

            // Used to manipulate database, not query
            int i = st.executeUpdate(sql);
            System.out.println("Number of updated rows: " + i);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
