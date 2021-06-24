package com.soliverosa.books.hanoi;

public class TowerOfHanoi {

    public static void main(String[] args) {
        //printArray(new int []{1,2,3,4}, 0);
        //System.out.println(numberRaisedTo(2, 3));
        System.out.println(isPalindrome("aas"));
        //System.out.println(reverseString("seba"));
        //towerOfHanoi('s', 'd', 'e' ,3);
    }

    private static boolean isPalindrome(String str) {
        if(str.length() == 1) return true;
        if(str.length() == 0) return true;
        if(str.charAt(0) == str.charAt(str.length()-1)) {
            return isPalindrome(str.substring(1, str.length()-1));
        }
        return false;
    }

    private static int numberRaisedTo(int base, int exp) {
        if(exp == 0) return 1;
        if(exp == 1) return base;
        return base * numberRaisedTo(base, exp-1);
    }

    private static void printArray(int[] ints, int position) {
        if(position == ints.length ) return;
        System.out.println(ints[position]);
        printArray(ints, position+1);
    }

    private static String reverseString(String str) {
        if(str.length() < 2) return str;
        return str.substring(str.length()-1, str.length()) +   reverseString(str.substring(0, str.length()-1));
    }

    private static void towerOfHanoi(char source, char destiny, char extra, int diskNumber) {
        if(diskNumber <= 0) {
            return;
        }
        towerOfHanoi(source, extra, destiny, diskNumber-1);
        System.out.println("Move disk-"+diskNumber+" FROM " + source + " TO " + destiny);
        towerOfHanoi(extra, destiny , source, diskNumber-1);
     }
}
