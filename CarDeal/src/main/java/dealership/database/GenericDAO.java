package dealership.database;

import dealership.model.User;

//<T> --> class used for dao object
//<K> --> primary key used by class
public interface GenericDAO<T, K> {

    void insert(T t);

    T get(K... id);

    T[] getAll();

    void update(String columnName, String value, K... id);

    void delete(K... id);

    //void updateAll(collection c);
}
