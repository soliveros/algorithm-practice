package com.soliverosa.generics;

import java.util.*;

public class IntArray {

    public static int[] removeDuplicateElements(int arr[]){
        int inputArrLength = arr.length;
        int[] outArr = new int[inputArrLength];
        int outArrPos = 0;
        for(int i = 0; i < arr.length; i++) {
            if(haveElement(outArr, arr[i])) {
                continue;
            }
            outArr[outArrPos] = arr[i];
            outArrPos++;
        }
        return removeZeroValues(outArr, outArrPos);
    }

    public static int [] removeZeroValues(int[] arr, int newArrLength) {
        int[] outArr = new int[newArrLength];
        for(int i = 0; i < arr.length; i++) {
            if(arr[i] == 0) {
                return outArr;
            } else {
                outArr[i] = arr[i];
            }
        }
        return outArr;
    }

    public static boolean haveElement(int[] arr, int elem) {
        for(int i = 0; i < arr.length; i++) {
            if(arr[i] == elem){
                return true;
            }
        }
        return false;
    }

    public static int[] orderAsc( int[] arr) {
        int[] outArr = new int[arr.length];
        int tmpElem = 0;
        for (int i = 0; i < arr.length ; i++) {
            for (int j = 0; j <arr.length ; j++) {
                if(arr[i] < arr[j]) {
                    tmpElem = arr[j];
                    arr[j] = arr[i];
                    arr[i] = tmpElem;
                }
            }
        }
        return arr;
    }

    public static int[] orderDesc( int[] arr) {
        int[] outArr = new int[arr.length];
        int tmpElem = 0;
        for (int i = 0; i < arr.length ; i++) {
            for (int j = 0; j <arr.length ; j++) {
                if(arr[i] > arr[j]) {
                    tmpElem = arr[j];
                    arr[j] = arr[i];
                    arr[i] = tmpElem;
                }
            }
        }
        return arr;
    }

    public static void main (String[] args) {
        int arr[] = {10,20,20,50,30,40,50,50, 100, 200, 1, 1000, 100, 20};

        int outArr[] = removeDuplicateElements(arr);

        int orderedArr[] = orderAsc(outArr);

        for(int i=0; i < orderedArr.length; i++) {
            System.out.println(orderedArr[i]);
        }

        int [] array = new int[] {1,5,8,4,8,6,5,5};

        //Using Streams - Sort and Dedup
        int [] newArray = Arrays.stream(array).sorted().distinct().toArray();
        System.out.println(Arrays.toString(newArray));

        //HashSet - Sort and Dedup
        TreeSet<Integer> newSet = new TreeSet<>();
        for(int i: array) {
            newSet.add(i);
        }
        System.out.println(Arrays.toString(newSet.toArray()));

        //ArrayList - Dedup and sort with stream
        List<Integer> newList = new ArrayList<Integer>();
        for(int i: array) {
            if(!newList.contains(i)) newList.add(i);
        }
        System.out.println(Arrays.toString(newList.stream().sorted().toArray()));
    }



}
