package com.soliverosa.hackerrank.jumpingclouds;

public class JumpingClouds {
    public static void main(String []args) {
        System.out.println(jumpingOnClouds(new int[] {0,1,0,0,0,1,0}));

    }

    static int jumpingOnClouds(int [] c) {
        int countJumps = 0;
        for (int i=0; i < c.length; i++) {
            if(i+2 < c.length && c[i+1] == 0 && c[i+2] == 0) {
                i+=1;
            } else if (i+1 < c.length  && c[i+1] == 1) {
                i+=1;
            }
            countJumps++;
        }
        return countJumps-1;
    }
}
