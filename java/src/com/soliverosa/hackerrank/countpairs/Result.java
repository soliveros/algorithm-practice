package com.soliverosa.hackerrank.countpairs;

import java.util.*;


class Result {

    public static void main(String [] args) {
        System.out.println(numberPairs(5, new int[]{10,20,10,50,20,20,20}));
    }

    // Complete the numberPairs function below.
    public static int numberPairs(int n, int[] ar) {
        Map<Integer, Integer> pairsInfo = new HashMap<Integer, Integer>();
        int countPairs = 0;
        for(int value: ar) {
            if (!pairsInfo.containsKey(value)) {
                pairsInfo.put(value, 1);
            } else {
                pairsInfo.put(value, pairsInfo.get(value) +1);
            }
        }

        Iterator<Integer> it = pairsInfo.keySet().iterator();
        while (it.hasNext()) {
            countPairs += (int)pairsInfo.get(it.next())/2;
        }
        return countPairs;
    }

}