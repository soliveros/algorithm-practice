package com.soliverosa.hackerrank.stdinout;

import java.util.Scanner;

public class sdtinout {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.print("Ingrese entero:");
        int i = scan.nextInt();
        System.out.print("Ingrese double:");
        Double d = scan.nextDouble();
        System.out.print("Ingrese string:");
        scan.nextLine();
        String s = scan.nextLine();
        scan.close();

        System.out.println("String: " + s);
        System.out.println("Double: " + d);
        System.out.println("Int: " + i);
    }

}


