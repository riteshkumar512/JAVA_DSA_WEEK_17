package Assignment_08;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

public class Playing_with_cards_Instack {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int q=sc.nextInt();
        int[] cards=new int[n];
        for (int i = 0; i < cards.length; i++) {
            cards[i]=sc.nextInt();
        }
        int[] prime=new int[q];
        prime(q,prime);
//        for (int i = 0; i < prime.length; i++) {
//            System.out.println(prime[i]+" ");
//        }
        CashinoGame(cards,q,prime);
    }
    public static int[] prime(int n,int[] primeArr){
        int[] prime= new int[130000];
        prime[0]=1;
        prime[1]=1;
        for (int i = 2; i*i < prime.length; i++) {
            if (prime[i] == 0) {
                for (int j = 2; i * j < prime.length; j++) {
                    prime[i * j] = 1;
                }
            }
        }
        int idx=0;
            for (int j = 2; j < prime.length && idx < primeArr.length ; j++) {
                if (prime[j]==0){
                    primeArr[idx++]=j;
                }
            }
        return primeArr;
    }

    public static void CashinoGame(int[] cards,int q,int[] prime){
        ArrayList<Stack<Integer>> bPile=new ArrayList<>();
        Stack<Integer> currentA=new Stack<>();
        for (int i = 0; i < cards.length; i++) {
            currentA.push(cards[i]);
        }
        for (int i = 0; i < q; i++) {
            Stack<Integer> NextA=new Stack<>();
            Stack<Integer> Bi=new Stack<>();
            while (!currentA.isEmpty()){
                int cardNo=currentA.pop();
                if (cardNo%prime[i]==0){
                    Bi.push(cardNo);
                }
                else {
                    NextA.push(cardNo);
                }
            }
            currentA=NextA;
            bPile.add(Bi);
        }
        for (Stack<Integer> stack : bPile) {

            while (!stack.isEmpty()) {
                System.out.println(stack.pop());
            }
        }
        while (!currentA.isEmpty()) {
            System.out.println(currentA.pop());
        }
    }


}
