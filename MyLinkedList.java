package Seminar3OOP;

import java.util.Iterator;


public class MyLinkedList implements Iterable{

    private Record head;
    private Record tail;
    private int count = 0;
    
    @Override
    public Iterator iterator() {
        return new Iterator<Object>() {
            Record element0 = new Record("0");
            {
                element0.setNext(head);
            }
            Record currentElement = element0;

            @Override
            public boolean hasNext() {
                return currentElement.getNext() != null;
            }

            @Override
            public Object next() {
                currentElement = currentElement.getNext();
                return currentElement.getData();
            }
        };
    }

    public int size() {
        return count;
    }

    private Record getElement(int index){
        if (index >= count){
            throw new IndexOutOfBoundsException();
        }

        Record result = head;
        for (int i = 1; i <= index; i++){
            result = result.getNext();
        }
        return result;
    }

    public Object get(int index){

        Record element = getElement(index);

        return element.getData();
    }

    public void remove(int index){

        Record currentElement = getElement(index);
        Record nextElement = currentElement.getNext();
        Record previousElement = currentElement.getPrevious();

        if (index == 0){
            head = nextElement;
            if (tail == currentElement){
                tail = null;
            }
        }

        if (index == count - 1){
            tail = previousElement;
            if (head == currentElement){
                head = null;
            }
        }

        count--;

        if (nextElement != null){
            nextElement.setPrevious(previousElement);
        }

        if (previousElement != null){
            previousElement.setNext(nextElement);
        }

    }

    public void add(int index, Object data){
        if (count == index){
            add(data);
            return;
        }
        count++;

        Record currentElement = new Record(data);

        if (index == 0){
            head = currentElement;
        }

        Record nextElement = getElement(index);
        Record previousElement = nextElement.getPrevious();

        currentElement.setNext(nextElement);
        currentElement.setPrevious(previousElement);

        if (previousElement != null) {
            previousElement.setNext(currentElement);
        }

    }

    public void add(Object data){
        count++;
        Record element = new Record(data);
        if (head == null){
            head = element;
            tail = element;
            return;
        } else if (tail == null) {
            tail = element;
            return;
        }

        tail.setNext(element);
        element.setPrevious(tail);
        tail = element;
    }
}