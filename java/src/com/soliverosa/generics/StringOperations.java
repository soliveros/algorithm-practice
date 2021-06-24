package com.soliverosa.generics;

import java.util.*;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StringOperations {

        public static void main(String[] args) {
            System.out.println(findSingleCharacter("aaasssddxwwweeggkkgg"));
        }

        //O(n)
        public static String findSingleCharacter(String str) {
            char [] array = str.toCharArray();
            HashMap<Character, Integer> map = new HashMap<>();
            for (int i = 0; i < array.length; i++) {
                int counts = 1;
                if (map.get(array[i]) != null) {
                    counts = map.get(array[i]);
                    counts++;
                }
                map.put(array[i], counts);
            }

            Iterator<Character> it = map.keySet().iterator();
            while(it.hasNext()){
                Character ch = it.next();
                if(map.get(ch) == 1) {
                    return ch.toString();
                }
            }
            return "No single characters found";
        }
}
