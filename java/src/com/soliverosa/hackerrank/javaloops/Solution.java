package com.soliverosa.hackerrank.javaloops;
//PRINT MULTIPLES FOR A NUMBER
public class Solution { 
    public static void main(String[] args) {
        printMultiples(2);
    }
    
    public static void printMultiples(int n) {
        for (int i = 1; i <= 10; i++) {
            System.out.println(n + " x " + i +" = " + n*i );
        }
    }
}
