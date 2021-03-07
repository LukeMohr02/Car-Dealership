package dealership.database;

import dealership.model.Offer;
import dealership.model.Offer;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

// Java Database Connectivity
public class OfferDAO implements GenericDAO<Offer, Integer> {

    private static OfferDAO instance;

    public OfferDAO() {
    }

    static OfferDAO getInstance() {
        if (instance == null) {
            instance = new OfferDAO();
        }
        return instance;
    }

    @Override
    public void insert(Offer offer) {
        try {
            PreparedStatement ps = new ConnectionSingleton().getConnection().prepareStatement("insert into offers values (?, ?, ?)");
            ps.setString(1, offer.getUserId());
            ps.setInt   (2, offer.getCarId());
            ps.setDouble(3, offer.getAmount());

            // Used to manipulate database, not query
            int i = ps.executeUpdate();
            System.out.println("Number of updated rows: " + i);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Offer get(Integer[] comp_id) {
        try {
            PreparedStatement ps = new ConnectionSingleton().getConnection().prepareStatement("select * from offers where car_id = ?;");
            ps.setInt(1, comp_id[0]);
            ResultSet rs = ps.executeQuery();

            rs.next();

            Offer offer = new Offer();
            offer.setCarId (rs.getInt   ("car_id"));
            offer.setUserId(rs.getString("user_id"));
            offer.setAmount(rs.getDouble("offer_amount"));

            return offer;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Offer[] getAll() {
        try {
            PreparedStatement ps = new ConnectionSingleton().getConnection().prepareStatement("select * from offers", ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ResultSet rs = ps.executeQuery();

            rs.last();
            Offer[] offers = new Offer[rs.getRow()];
            rs.beforeFirst();

            while (rs.next()) {
                Offer offer = new Offer();
                offer.setCarId (rs.getInt   ("car_id"));
                offer.setUserId(rs.getString("user_id"));
                offer.setAmount(rs.getDouble("offer_amount"));
                offers[rs.getRow() - 1] = offer;
            }

            return offers;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void update(String columnName, String value, Integer[] car_id) {
        try {
            PreparedStatement ps = new ConnectionSingleton().getConnection().prepareStatement("update offers set " + columnName + " = ? where \"car_id\" = ?");
            ps.setString(1, value);
            ps.setInt   (2, car_id[0]);

            // Used to manipulate database, not query
            int i = ps.executeUpdate();
            System.out.println("Number of updated rows: " + i);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(Integer[] car_id) {
        try {
            PreparedStatement ps = new ConnectionSingleton().getConnection().prepareStatement("delete from offers where \"car_id\" = ?;");
            ps.setInt(1, car_id[0]);

            int i = ps.executeUpdate();
            System.out.println("Number of updated rows: " + i);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
