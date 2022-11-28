package gb.demo.homework;

import java.util.Iterator;

public class Main {
    public static void main(String[] args){
        //тесты коллекций
        MyArrayList<Integer> myArray = new MyArrayList<>();
        Integer[] insertionArray = new Integer[]{1,2,3,4,5,6,7,8,9,10};
        myArray.add(1);
        myArray.add(3);
        myArray.insert(1, insertionArray);
        myArray.add(4);
        myArray.delete(4);
        System.out.println(myArray.get(4));

        Iterator<Integer> iterator = myArray.iterator();
        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }


        MyLinkedList<Integer> myLinkedList= new MyLinkedList<>();
        myLinkedList.add(1);
        myLinkedList.add(3);
        myLinkedList.add(4);
        myLinkedList.insert(1, insertionArray);
        myLinkedList.delete(4);
        System.out.println(myLinkedList.get(4));

        Iterator<Integer> iterator2 = myLinkedList.iterator();
        while(iterator2.hasNext()){
            System.out.println(iterator2.next());
        }

    }
}
