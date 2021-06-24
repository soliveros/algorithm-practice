package com.soliverosa.hackerrank.staticblock;
import java.util.*;

public class Solution {

    static boolean flag;
    static int B;
    static int H;
    static {
        Scanner scan = new Scanner(System.in);
        System.out.print("Ingrese valor 1:");
        B = scan.nextInt();
        System.out.print("Ingrese valor 2:");
        H = scan.nextInt();
        if( B <= 0 || H<= 0 ) {
            System.out.println("java.lang.Exception: Breadth and height must be positive");
        } else {
            flag = true;
        }
    }

    public static void main(String[] args){
        if(flag){
            int area=B*H;
            System.out.print(area);
        }

    }//end of main

}//end of class