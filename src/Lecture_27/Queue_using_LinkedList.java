package Lecture_27;


import java.util.*;

public class Queue_using_LinkedList {
    public static void main(String[] args) {
        LinkedList<Integer> ll=new LinkedList<>();
        ll.add(10);
        ll.add(20);
        ll.add(30);
        ll.add(40);
        ll.add(50);
        System.out.println(ll);
        System.out.println(ll.remove());
        System.out.println(ll);

        Queue<Integer> q=new LinkedList<>();
        q.add(10);
        q.add(20);
        q.add(30);
        q.add(40);
        q.add(50);
        System.out.println(q);
        System.out.println(q.remove());
        System.out.println(q.poll());
        System.out.println(q.peek());
        System.out.println(q);


    }

}
