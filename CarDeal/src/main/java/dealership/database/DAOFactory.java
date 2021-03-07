package dealership.database;

public class DAOFactory {

    public static GenericDAO getDAO(Class clazz) throws IllegalAccessException {

        switch (clazz.getName()) {
            case "dealership.model.Car":
                return CarDAO.getInstance();
            case "dealership.model.Payment":
                return PaymentDAO.getInstance();
            case "dealership.model.User":
                return UserDAO.getInstance();
            default:
                throw new IllegalAccessException("No DAO object available for class: " + clazz.getName());
        }
    }

    public static GenericCompositeDAO getCompositeDAO(Class clazz) throws IllegalAccessException {

        switch (clazz.getName()) {
            case "dealership.model.Offer":
                return OfferDAO.getInstance();
            default:
                throw new IllegalAccessException("No composite DAO object available for class: " + clazz.getName());
        }
    }
}
