package Recursion;

import java.util.Scanner;

public class SumOfFirstN {
    // time complexity: O(N)
    // space complexity: O(N)
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter n: ");
        int n = sc.nextInt();
        int sum = 0;
        sumRec(n,sum);

        int method2sum = sumOfNaturalNumbers(n);
        System.out.println(method2sum);
    }
    public static void sumRec(int n, int sum){
        if(n<1){
            System.out.println("sum: "+sum);
            return;
        }
        sum += n;
        sumRec(n-1,sum);
    }

    public static int sumOfNaturalNumbers(int n){
        if(n==1) return 1;
        return n+sumOfNaturalNumbers(n-1);
    }
}
