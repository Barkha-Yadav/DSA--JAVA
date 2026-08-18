package Recursion;

import java.util.Scanner;

public class Factorial {
    // time complexity: O(n)
    // space complexity: O(n)
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter n: ");
        int n = sc.nextInt();
        System.out.println(n+"! is "+fact(n));
    }
    public static int fact(int n){
        if(n==0) return 1;
        return n*fact(n-1);
    }
}
