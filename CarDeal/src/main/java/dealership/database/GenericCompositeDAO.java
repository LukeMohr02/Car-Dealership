package dealership.database;

import dealership.model.User;

//<T> --> class used for dao object
//<K1> --> 1st primary key
//<k2> --> 2nd primary key
public interface GenericCompositeDAO<T, K1, K2> {

    void insert(T t);

    T get(K1 id, K2 id2);

    T[] getAll();

    void update(K1 id1, K2 id2, String columnName, String value);

    void delete(K1 id1, K2 id2);

    //void updateAll(collection c);
}
