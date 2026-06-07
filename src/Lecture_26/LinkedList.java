package Lecture_26;

public class LinkedList {
  private class Node{
        int val;
        Node next;

        public Node(int val){
            this.val=val;
        }

    }
    private Node head;
    private Node tail;
    private int size;

    public int size(){
        return size;
    }

//    TC-->O(N)
    public void addFirst(int item){
        Node node=new Node(item);
        if (size==0){
            head=node;
            tail=node;
            size++;
        }else {
            node.next=head;
            head=node;
            size++;
        }
    }
    /*-------------------------------------------------------------------------------*/
//    TC-->O(N)
    public void addLast(int item){
        if (size==0){
            addFirst(item);
        }else {
            Node node=new Node(item);
            tail.next=node;
            tail=node;
            size++;
        }
    }
    /*-------------------------------------------------------------------------------*/

    public void addAtIndex(int k,int item){
        if (k==0){
            addFirst(item);
        } else if (k==size){
            addLast(item);
        }
        else {
            Node node=new Node(item);
            Node prev=getNode(k-1);
            node.next=prev.next;
            prev.next=node;
            size++;
        }
    }
    private Node getNode(int k){
        Node temp=head;
        for (int i = 0; i <= k; i++) {
            temp=temp.next;
        }
        return temp;
    }
    /*-------------------------------------------------------------------------------*/
    //    TC-->O(1)
    public int getFirst(){
        return head.val;
    }
    //    TC-->O(1)
    public int getLast(){
        return tail.val;
    }
    //    TC-->O(N)
    public int getAtIndex(int k){
        return getNode(k).val;
    }
    /*-------------------------------------------------------------------------------*/

    public int removeFirst(){
        Node curr=head;
        if (size==1){
            head=null;
            tail=null;
            size--;
        }else {
            head=head.next;
            curr.next=null;
            size--;
        }
        return curr.val;
    }

    public int removeLast(){
        if (size==1){
            return removeFirst();
        }else {
            Node prev=getNode(size-2);
            int val=tail.val;
            tail=prev;
            tail.next=null;
            size--;
            return val;
        }
    }

    public int removeAtIndex(int k){
        if (k==0){
            return removeFirst();
        } else if (k==size-1) {
            return removeLast();
        }
        else {
            Node prev=getNode(k-1);
            Node curr=prev.next;
            prev.next=curr.next;
            curr.next=null;
            size--;
            return curr.val;
        }
    }

    /*-------------------------------------------------------------------------------*/

    public void display(){
        Node temp=head;
        while (temp!=null){
            System.out.print(temp.val + "-->");
            temp=temp.next;
        }
        System.out.println(".");
    }



}
