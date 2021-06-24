package com.soliverosa.codewars.englishbeggars;

public class Kata {
    public static void main (String [] args) {
        int[] array = beggars(new int[]{1,2,3,4,5}, 3);
        for(int i: array)
            System.out.println(i);
    }

    public static int[] beggars(int[] values, int n) {
        if(n==0) return new int []{};
        int[] result = new int[n];
        for (int i = 0; i < values.length; i++) {
            if (i>=n){
                result[i%n] += values[i];
            } else {
                result[i] += values[i];
            }

        }
        return result;
    }
}
