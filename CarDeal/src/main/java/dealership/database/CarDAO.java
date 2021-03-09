package dealership.database;

import dealership.model.Car;
import dealership.service.UserService;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

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
    public void insert(Car car) {
        try {
            PreparedStatement ps = new ConnectionSingleton().getConnection().prepareStatement("insert into cars (\"car_make\", \"car_model\", \"car_year\", \"car_color\", \"car_owner\") values (?, ?, ?, ?, ?);");
            ps.setString(1, car.getMake());
            ps.setString(2, car.getModel());
            ps.setInt   (3, car.getYear());
            ps.setString(4, car.getColor());
            ps.setString(5, car.getOwner()==null?null:car.getOwner().getUsername());

            // Used to manipulate database, not query
            int i = ps.executeUpdate();
            System.out.println("Number of updated rows: " + i);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Car get(Integer id) {
        try {
            PreparedStatement ps = new ConnectionSingleton().getConnection().prepareStatement("select * from cars where id = ?;");
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            rs.next();

            Car Car = new Car();
            Car.setId   (rs.getInt   ("id"));
            Car.setMake (rs.getString("car_make"));
            Car.setModel(rs.getString("car_model"));
            Car.setYear (rs.getInt   ("car_year"));
            Car.setColor(rs.getString("car_color"));
            Car.setOwner(new UserService().getUser(rs.getString("car_owner")));

            return Car;
        } catch (SQLException | IllegalAccessException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Car[] getAll() {
        try {
            PreparedStatement ps = new ConnectionSingleton().getConnection().prepareStatement("select * from cars", ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ResultSet rs = ps.executeQuery();

            rs.last();
            Car[] cars = new Car[rs.getRow()];
            rs.beforeFirst();

            while (rs.next()) {
                Car Car = new Car();
                Car.setId   (rs.getInt   ("id"));
                Car.setMake (rs.getString("car_make"));
                Car.setModel(rs.getString("car_model"));
                Car.setYear (rs.getInt   ("car_year"));
                Car.setColor(rs.getString("car_color"));
                Car.setOwner(new UserService().getUser(rs.getString("car_owner")));
                cars[rs.getRow() - 1] = Car;
            }

            return cars;
        } catch (SQLException | IllegalAccessException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void update(Integer id, String columnName, String value) {
        try {
            PreparedStatement ps = new ConnectionSingleton().getConnection().prepareStatement("update cars set " + columnName + " = ? where \"id\" = ?;");
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
    public void delete(Integer id) {
        try {
            PreparedStatement ps = new ConnectionSingleton().getConnection().prepareStatement("delete from Cars where \"id\" = ?;");
            ps.setInt(1, id);

            int i = ps.executeUpdate();
            System.out.println("Number of updated rows: " + i);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void callFunction() {
        try {
            PreparedStatement ps = new ConnectionSingleton().getConnection().prepareCall("select reset_car_id();");

            boolean b = ps.execute();
            System.out.println("Successfully reset car IDs: " + b);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
