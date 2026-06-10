package Assignment_08;

import java.util.Scanner;
import java.util.Stack;

public class The_Queue_Game {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- >0) {
            int n = sc.nextInt();
            int[] array = new int[n];
            for (int i = 0; i < array.length; i++) {
                array[i] = sc.nextInt();
            }
            boolean ans = checkValidOrNot(array);
            if (ans) {
                System.out.println("Valid");
            } else {
                System.out.println("Invalid");
            }
        }
    }
    public static boolean checkValidOrNot(int[] arr){
        Stack<Integer> st=new Stack<>();
        for (int i = 0; i < arr.length; i++) {

            if (arr[i] == 1){
                st.push(i);
            }else {
                if (st.isEmpty()){
                    return false;
                }
                st.pop();
            }
        }
        return true;
    }
}
