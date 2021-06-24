package com.soliverosa.hackerrank.format;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class OutputFormat {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("================================");
        List<String> list = new ArrayList<String>();
        list.add("java 100");
        list.add("cpp 65");
        list.add("python 50");
        Iterator<String> it = list.iterator();
        while(it.hasNext()) {
            System.out.println(formatLine(it.next()));
        }
        System.out.println("================================");

    }

    public  static String formatLine(String str) {
        char [] arrayChar = new char[15];
        char [] inputStr = str.split(" ")[0].toCharArray();
        for (int i = 0; i < arrayChar.length; i++) {
            if(i < inputStr.length) {
                arrayChar[i] = inputStr[i];
            } else {
                arrayChar[i] = ' ';
            }
        }
        String number = str.split(" ")[1];
        return String.valueOf(arrayChar) + numberPrefix(number)+number;
    }

    private static String numberPrefix(String s) {
        if(s.length() == 3) return "";
        if(s.length() == 2) return "0";
        if(s.length() == 1) return "00";
        return s;
     }
}
