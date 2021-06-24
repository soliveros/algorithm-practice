package com.soliverosa.hackerrank.spiralmatrix;

import java.util.Arrays;

public class SpiralMatrix {

    public static  void main (String [] args) {

        //System.out.println(Arrays.deepToString(spiral(4)).replace("],","],\n"));
        System.out.println(Arrays.deepToString(
                recursiveSpiral(0, 0, 0, 0,new int[4][4])).replace("],","],\n")
        );
    }

    private static int[][] spiral(int n) {
        int[] dc = new int[]{1,0,-1,0};
        int[] dr = new int[]{0,1,0,-1};
        int dir = 0, val=0, r=0, c=0,limit=n*n;
        int[][] matrix = new int[n][n];
        while (val++ < limit) {
            matrix[r][c] = val;
            r += dr[dir];
            c += dc[dir];
            if (isInvalid(matrix, r, c)) {
                r -= dr[dir];
                c -= dc[dir];
                dir = (dir + 1) % 4;
                r += dr[dir];
                c += dc[dir];
            }
        }
        return matrix;
    }

    private static boolean isInvalid(int[][] m, int r, int c) {
        return r<0||c<0||r>=m.length||c>= m.length||m[r][c] != 0;
    }

    private static int[][] recursiveSpiral(int row, int column, int dir, int val , int[][] matrix) {
        //int[] dc = new int[]{1,0,-1,0};
        //int[] dr = new int[]{0,1,0,-1};
        int[] dc = new int[]{0,1,0,-1};
        int[] dr = new int[]{1,0,-1,0};
        if(val != matrix.length * matrix.length)
        {
            val++;
            matrix[row][column] = val;
            row += dr[dir];
            column += dc[dir];
            if(isInvalid(matrix, row, column)) {
                row -= dr[dir];
                column -= dc[dir];
                dir = (dir + 1) % 4;
                row += dr[dir];
                column += dc[dir];
            }
            recursiveSpiral(row, column, dir, val, matrix);
        }
        return matrix;

    }
}


