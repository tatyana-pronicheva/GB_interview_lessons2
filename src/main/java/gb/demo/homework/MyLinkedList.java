package gb.demo.homework;


import java.util.Iterator;

public class MyLinkedList<E> implements MyList {
    int size = 0;
    Node<E> first;
    Node<E> last;

    private static class Node<E> {
        E item;
        Node<E> next;
        Node<E> prev;

        Node(Node<E> prev, E element, Node<E> next) {
            this.item = element;
            this.next = next;
            this.prev = prev;
        }
    }

    @Override
    public void add(Object item) {
        if (size==0){
            Node<E> newNode = new Node<E>(null, (E)item, null);
            first = newNode;
            last = newNode;
            size++;
            return;
        } else {
            Node<E> newNode = new Node<E>(last, (E) item, null);
            last.next = newNode;
            last = newNode;
            size++;
        }
    }

    public Node<E> getNode(int index) {
        Node<E> x = first;
        for (int i = 0; i < index; i++)
            x = x.next;
        return x;
    }

    @Override
    public E get(int index) {
        Node<E> x = first;
        for (int i = 0; i < index; i++)
            x = x.next;
        return x.item;
    }

    @Override
    public void insert(int index, Object[] arrayForInsertion) {
        MyLinkedList<E> listForInsertion = new MyLinkedList<>();
        for (int i = 0; i < arrayForInsertion.length; i++){
            listForInsertion.add(arrayForInsertion[i]);
        }
        Node<E> endOfInsertion = getNode(index);
        Node<E> startOfInsertion = endOfInsertion.prev;
        listForInsertion.first.prev = startOfInsertion;
        listForInsertion.last.next = endOfInsertion;
        startOfInsertion.next = listForInsertion.first;
        endOfInsertion.prev = listForInsertion.last;
    }


    @Override
    public void delete(int index) {
        Node<E> nodeForRemoving = getNode(index);
        nodeForRemoving.prev.next = nodeForRemoving.next;
        nodeForRemoving.next.prev = nodeForRemoving.prev;
    }

    @Override
    public Iterator iterator() {
        return new MyLinkedList.MyIterator();
    }
    private class MyIterator implements Iterator<E>{
        Node<E> lastReturned;

        @Override
        public boolean hasNext() {
            return !(lastReturned==last);
        }

        @Override
        public E next() {
            if (lastReturned ==null){
                lastReturned = first;
                return first.item;
            }
            lastReturned = lastReturned.next;
            return lastReturned.item;
        }
    }
}
