package dealership.collections;


public interface List<E> extends Collection<E> {

    void order();

    int indexOf(E e);
}
