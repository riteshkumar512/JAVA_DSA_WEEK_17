package Assignment_08;

import java.util.Scanner;
import java.util.Stack;

public class Stock_Span {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int[] stocks =new int[n];
        for (int i = 0; i < stocks.length ; i++) {
            stocks[i]=sc.nextInt();
        }
        span(stocks);
    }

    public static void span(int[]arr) {
        Stack<Integer> st=new Stack<>();
        int[]ans=new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            while (!st.isEmpty() && arr[i]>= arr[st.peek()]){
                st.pop();
            }
            if (st.isEmpty()){
                ans[i]=i+1;
            }else {
                ans[i]=i-st.peek();
            }
            st.push(i);
        }
        for (int i = 0; i < ans.length; i++) {
            System.out.print(ans[i]+" ");
        }
        System.out.println("END");
    }
}
