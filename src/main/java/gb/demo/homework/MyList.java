package gb.demo.homework;

public interface MyList<T> extends Iterable {
   T get(int index);

    void insert(int index, T[] arrayForInsertion);

    void add(Object item);

    void delete(int index);
}
