package Assignment_08;

import java.util.Scanner;
import java.util.Stack;

public class Histogram {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int[] bars=new int[n];
        for (int i = 0; i < bars.length; i++) {
            bars[i]= sc.nextInt();
        }
        System.out.println(maxArea(bars));
    }

    public static int maxArea(int[] arr) {
        Stack<Integer> st = new Stack<>();
        int ans = 0;
        for (int i = 0; i < arr.length; i++) {
            while (!st.isEmpty() && arr[i] < arr[st.peek()]) {
                int h = arr[st.pop()];
                int r = i;
                if (st.isEmpty()) {
                    ans = Math.max(ans, h * r);
                } else {
                    int l = st.peek();
                    ans = Math.max(ans, h * (r - l - 1));
//                    System.out.println("a->"+"h:"+ h+ " l:" + l +" r:"+r +" area:"+ ans);
                }
            }
            st.push(i);
        }
        int r = arr.length;
        while (!st.isEmpty()) {
            int h = arr[st.pop()];
            if (st.isEmpty()) {
                ans = Math.max(ans, h * r);
                //System.out.println("b->" + " h:" + h + " r:" + r + " area:" + ans);
            } else {
                int l = st.peek();
                ans = Math.max(ans, h * (r - l - 1));
                //System.out.println("c->" + "h:" + h + " l:" + l + " r:" + r + " area:" + ans);
            }
        }
        return ans;
    }
}
