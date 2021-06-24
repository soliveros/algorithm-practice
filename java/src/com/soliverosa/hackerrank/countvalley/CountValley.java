package com.soliverosa.hackerrank.countvalley;

public class CountValley {

    public static void main(String [] args) {
        System.out.println(countingValleys(8, "DDUUUUDD"));
    }
    // Complete the countingValleys function below.
    static int countingValleys(int n, String s) {
        int countValley = 0;
        int altZero = 0;
        String[] pathArray = s.split("");
        for (String step: pathArray) {
            if(altZero == 0 && step.equals("D")) {
                countValley+=1;
            }
            if(step.equals("U")) {
                altZero+=1;
            }
            if(step.equals("D")) {
                altZero-=1;
            }
        }
        return countValley;
    }
}
