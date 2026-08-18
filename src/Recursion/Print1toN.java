package Recursion;

import java.util.Scanner;

public class Print1toN {
    // time complexity: O(N)
    // space complexity: O(N) because of stack overhead
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter n: ");
        int n = sc.nextInt();
        printTillN(n,1);
    }
    public static void printTillN(int n, int curr){
        if(curr>n) return;
        System.out.print(curr+" ");
        printTillN(n,curr+1);
    }
}
