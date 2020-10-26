package uaslp.enginering.labs.list;

public interface List<T> {

    void add(T element);

    void delete(T element);

    void delete(int index);

    Iterator<T> getIterator();

    int size();

    T getAt(int index);

    void insert(T reference, T newStudent, InsertPosition insertPosition);
}
