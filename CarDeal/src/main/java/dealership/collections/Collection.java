package dealership.collections;

public interface Collection<E> {

    int maxSize = 0;

    E get(E e);

    void add(E e) throws Exception;

    int size();

    void remove(E e);

    E next();

    E previous();

    String toString();

    boolean isEmpty();

    void clear();

}
