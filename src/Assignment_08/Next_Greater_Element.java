package Assignment_08;

import java.util.Scanner;
import java.util.Stack;

public class Next_Greater_Element {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int[] arr=new int[n];
        for (int i = 0; i < arr.length; i++) {
            arr[i]= sc.nextInt();
        }
        NGE(arr);
    }
    public static void  NGE(int [] arr ){
        Stack<Integer>st=new Stack<>();
        int[]ans=new int[arr.length];

        for (int i = 0; i < arr.length; i++) {
            while (!st.isEmpty() && arr[i] > arr[st.peek()]) {
                ans[st.pop()] = arr[i];
            }
            st.push(i);
        }
            while (!st.isEmpty()){
                ans[st.pop()]=-1;
            }
        for (int i = 0; i < ans.length; i++) {
            System.out.print(ans[i]+" ");
        }
    }
}
