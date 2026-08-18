package Recursion;

import java.util.Scanner;

public class PrintNto1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter n: ");
        int n = sc.nextInt();
        printTill1(n);
    }
    public static void printTill1(int n){
        if(n<1) return;
        System.out.print(n+" ");
        printTill1(n-1);
    }
}
