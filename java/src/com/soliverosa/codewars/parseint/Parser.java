package com.soliverosa.codewars.parseint;

import java.util.*;

public class Parser {
    public static void main(String [] str) {
        System.out.println(sumNumericalUnits(generateNumericalUnits("seven hundred eighty-three thousand nine hundred nineteen"), 0, 1));
    }

    public static int parseInt(String numStr) {
        System.out.println(numStr);
        return sumNumericalUnits(generateNumericalUnits(numStr.replace(" and ", " ")), 0, 1);
    }

    public static int sumNumericalUnits(ArrayList<String> numUnitsList, int result, int positionalValue) {
        if(numUnitsList.size() == 0) {
            return result;
        }
        Iterator<String> it = numUnitsList.iterator();
        while (it.hasNext()) {
            String [] values = it.next().split(" ");
            int unitValue = 1;
            for (int i = 0; i < values.length; i++) {
                if(values[i].contains("-")) {
                    unitValue = unitValue * sumNumericalUnits(
                            new ArrayList<String>(Arrays.asList(values[i].split("-"))), 0, 1
                    );
                    continue;
                }
                unitValue = unitValue * WordValue().get(values[i]);
            }
            it.remove();
            return sumNumericalUnits(numUnitsList, result + unitValue, positionalValue + 1);
        }
        return  result;
    }

    public static ArrayList<String> generateNumericalUnits(String numStr) {
        boolean nextHundredMultipier = false;
        ArrayList<String> numericalUnits = new ArrayList<String>();
        LinkedList<String> numStrList = new LinkedList<String>(Arrays.asList(numStr.split(" ")));
        Iterator<String> it = numStrList.descendingIterator();
        while (it.hasNext()) {
            String value = it.next();
            if(Arrays.asList("thousand","hundred","million").contains(value)) {
                if(value.equals("thousand")) {
                    if(numStr.contains("hundred thousand")) {
                        value = it.next() + " " + value;
                        value = it.next() + " " + value;
                        numericalUnits.add(value);
                        continue;
                    } else {
                        nextHundredMultipier = true;
                    }
                }
                if( nextHundredMultipier == true && value.equals("hundred")) {
                    value = "hundred thousand";
                }
                value = it.next() + " " + value;
            }
            numericalUnits.add(value);
        }
        return numericalUnits;
    }

    private static Map<String, Integer> WordValue() {
        Map<String, Integer> wordValue = new HashMap<String, Integer>();
        wordValue.put("zero", 0);
        wordValue.put("one",1);
        wordValue.put("two",2);
        wordValue.put("three",3);
        wordValue.put("four",4);
        wordValue.put("five",5);
        wordValue.put("six",6);
        wordValue.put("seven",7);
        wordValue.put("eight",8);
        wordValue.put("nine",9);
        wordValue.put("ten",10);
        wordValue.put("eleven",11);
        wordValue.put("twelve",12);
        wordValue.put("thirteen",13);
        wordValue.put("fourteen",14);
        wordValue.put("fifteen",15);
        wordValue.put("sixteen",16);
        wordValue.put("seventeen",17);
        wordValue.put("eighteen",18);
        wordValue.put("nineteen",19);
        wordValue.put("twenty",20);
        wordValue.put("thirty",30);
        wordValue.put("forty",40);
        wordValue.put("fifty",50);
        wordValue.put("sixty",60);
        wordValue.put("seventy",70);
        wordValue.put("eighty",80);
        wordValue.put("ninety",90);
        wordValue.put("hundred",100);
        wordValue.put("thousand",1000);
        wordValue.put("million",1000000);
        return wordValue;
    }

    public static int parseInt2(String numStr) {
        String[] numArray = numStr.split("[ |-]");
        int number = 0;
        Map<String, Integer> map = new HashMap<String, Integer>();
        map.put("zero", 0);
        map.put("one", 1);
        map.put("two", 2);
        map.put("three", 3);
        map.put("four", 4);
        map.put("five", 5);
        map.put("six", 6);
        map.put("seven", 7);
        map.put("eight", 8);
        map.put("nine", 9);
        map.put("ten", 10);
        map.put("eleven", 11);
        map.put("twelve", 12);
        map.put("thirteen", 13);
        map.put("fourteen", 14);
        map.put("fifteen", 15);
        map.put("sixteen", 16);
        map.put("seventeen", 17);
        map.put("eighteen", 18);
        map.put("nineteen", 19);
        map.put("twenty", 20);
        map.put("thirty", 30);
        map.put("forty", 40);
        map.put("fifty", 50);
        map.put("sixty", 60);
        map.put("seventy", 70);
        map.put("eighty", 80);
        map.put("ninety", 90);
        map.put("hundred", 100);
        map.put("thousand", 1000);
        map.put("million", 1000000);

        for (int i = 0; i < numArray.length; i++) {
            for (String key : map.keySet()) {
                if (numArray[i].toLowerCase().equals(key)) {
                    if (map.get(key) == 100) {
                        int temp = number % 100;
                        number -= temp;
                        number += temp * (map.get(key));
                    }
                    else if (map.get(key) > 100)
                        number *= (map.get(key));
                    else
                        number += map.get(key);
                    break;
                }
            }
        }
        return number;
    }
}



