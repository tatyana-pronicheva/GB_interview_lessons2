package gb.demo.homework;

import java.util.*;

public class MyArrayList<T> implements MyList{
    private T[] array;
    private int indexAfterLastElement;

    public MyArrayList(){
        array = (T[]) new Object[16];
        indexAfterLastElement = 0;
    }

    public T[] increaseSize(){
        return Arrays.copyOf(array, array.length*3/2+1);
    }

    @Override
    public T get(int index) {
        return array[index];
    }

    @Override
    public void add(Object item) {
        if (indexAfterLastElement == array.length) increaseSize();
        try {
            array[indexAfterLastElement] = (T) item;
            indexAfterLastElement++;
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void insert(int index, Object[] arrayForInsertion) {
        while (indexAfterLastElement + arrayForInsertion.length > array.length) {increaseSize();}
        System.arraycopy(array, index, array, index + arrayForInsertion.length, indexAfterLastElement -index);
        System.arraycopy(arrayForInsertion, 0, array, index, arrayForInsertion.length);
        indexAfterLastElement = indexAfterLastElement +arrayForInsertion.length;
    }

    @Override
    public void delete(int index) {
        System.arraycopy(array, index+1, array, index, indexAfterLastElement -index);
        array[indexAfterLastElement] = null;
        indexAfterLastElement--;
    }

    @Override
    public Iterator iterator() {
        return new MyIterator();
    }
    private class MyIterator implements Iterator<T>{
        int cursor;       // index of next element to return
        int size = indexAfterLastElement;

        @Override
        public boolean hasNext() {
            return cursor!=size;
        }

        @Override
        public T next() {
            int i = cursor;
            cursor = i + 1;
            return (T) array[i];
        }
    }

}