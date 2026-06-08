package Assignment_08;

import java.util.Scanner;
import java.util.Stack;

public class Dequeueefficientqueueusingstack {
    public static void main(String[] args) throws Exception {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        QueueImplemt(n);
    }
    public static void QueueImplemt(int n)throws Exception{
        Stack<Integer> st=new Stack<>();
        for (int i = 0; i < n; i++) {
            st.push(i);
        }
        Stack<Integer>st2=new Stack<>();
        while (!st.isEmpty()){
            st2.push(st.pop());
        }
        while (!st2.isEmpty()){
            System.out.print(st2.pop()+" ");
        }

    }
}
