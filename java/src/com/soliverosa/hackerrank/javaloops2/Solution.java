package com.soliverosa.hackerrank.javaloops2;

public class Solution {
    public static void main(String[] args) {
        printSerie(5,3,5);
        //System.out.println(powerOf(2, 4));
    }

    public static void printSerie(int a, int b, int n) {
        StringBuilder strB = new StringBuilder();
        for (int i = 1; i <= n; i++) {
            if(i<n) {
                strB.append(result(a, b, i ) + " ");
            } else {
                strB.append(result(a, b, i));
            }
        }
        System.out.println(strB.toString());
    }

    public static int result(int a, int b, int i) {
        int result = 0;
        for (int j = 0; j < i; j++) {
            result = result + powerOf(2, j) * b;
        }
        return a + result;
    }

    public static int powerOf(int n, int e) {
        if(e == 0) return 1;
        if(e == 1) return n;
        return n * powerOf(n , e-1);
    }


}
