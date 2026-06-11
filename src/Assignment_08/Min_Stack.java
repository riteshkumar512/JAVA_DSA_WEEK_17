package Assignment_08;

import java.util.Scanner;

public class Min_Stack {
    protected int[] arr;
    protected int[] minArr;
    protected int idx=-1;


    Min_Stack(){
        this(5);
    }
    Min_Stack(int n){
        arr=new int[n];
        minArr=new int[n];
    }
    public boolean isEmpty(){
        return idx==-1;
    }
    public boolean isFull(){
        return idx==arr.length-1;
    }
    public int push(int item) throws Exception {
        if (isFull()) {
            int[] newArr = new int[2 * arr.length];
            int[] newMinArr=new int[2*arr.length];
            for (int i = 0; i < arr.length; i++) {
                newArr[i] = arr[i];
                newMinArr[i]=minArr[i];
            }
            arr=newArr;
            minArr=newMinArr;
        }
            arr[++idx]=item;
            if (idx==0){
                minArr[idx]=item;
            }
            else {
            minArr[idx]=Math.min(minArr[idx-1],item);
        }
        return item;
    }
    public int pop() throws Exception{
        if (isEmpty()){
            throw new Exception("Stack is Empty");
        }
        int val=arr[idx--];
        return val;
    }
    public int top() throws Exception {
        if (isEmpty()){
            throw new Exception("Stack is empty");
        }
        int val=arr[idx];
        return val;
    }
    public int getMin() throws Exception{
        if (isEmpty()){
            throw new Exception("Stack is Empty");
        }
        int val=minArr[idx];
        return val;
    }

    public static void main(String[] args) throws Exception {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        String [] st=new String[n];
        for (int i = 0; i < st.length; i++) {
            st[i]=sc.next();
        }
        int pushCount =0;
        for (int i = 0; i < st.length; i++) {
            if (st[i].equals("push")){
                pushCount++;
            }
        }
        int[] value=new int[pushCount];
        for (int i = 0; i < pushCount; i++) {
            value[i]=sc.nextInt();
        }
        Min_Stack stack=new Min_Stack();
        int idx=0;
        for (int i = 0; i < st.length; i++) {
            if (st[i].equals("push")){
                stack.push(value[idx++]);
            }
            if (st[i].equals("pop")){
                stack.pop();
            }
            if(st[i].equals("top")){
                System.out.println(stack.top());
            }
            if (st[i].equals("getMin")){
                System.out.println(stack.getMin());
            }
        }
    }
}



