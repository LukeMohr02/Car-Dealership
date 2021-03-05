package dealership.database;

import dealership.model.User;

//<T> --> class used for dao object
//<K> --> primary key used by class
public interface GenericDAO<T, K> {

    void insert(T t);

    T get(K id);

    T[] getAll();

    void remove(K id);

    //void update(T t);

    //void updateAll(collection c);
}
