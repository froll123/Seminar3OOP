package Seminar3OOP;

import java.util.Iterator;

public class Main {

    public static void main(String[] args) {

        MyLinkedList list = new MyLinkedList();
        list.add("meaning1");
        list.add("meaning2");

        list.add(1, "meaning2_1");


        Iterator<String> iterator = list.iterator();
        while (iterator.hasNext()){
            String element = iterator.next();
            System.out.println(element);
        }

    }
    
}
