package org.example;

import java.util.Arrays;

public class ReverseMatrix {

    public void reverseRowsCols(int[][] mtrx){
        System.out.println("Reversing Rows & Cols");
        printMatrix(mtrx);

        for (int r=0; r<mtrx.length; r++){
            for (int c=r+1; c<mtrx[r].length; c++){
                int tmp = mtrx[r][c];
                mtrx[r][c] = mtrx[c][r];
                mtrx[c][r] = tmp;
            }
        }

        System.out.println("");
        System.out.println("Reversed Rows and Cols");
        printMatrix(mtrx);
    }

    public void reverseInitToEnd(int[][] mtrx) {
        System.out.println("Reversing Init To End");
        printMatrix(mtrx);

        int rows = mtrx.length;
        int cols = mtrx[0].length;
        int tot = rows * cols;
        int r1 = 0, c1 = 0, r2 = 0, c2 = 0, tmp = 0;

        for (int i=0; i<tot/2; i++){
            r1 = i / cols;
            c1 = i % cols;

            r2 = (tot - 1 - i) / cols;
            c2 = (tot - 1 - i) % cols;

            tmp = mtrx[r1][c1];
            mtrx[r1][c1] = mtrx[r2][c2];
            mtrx[r2][c2] = tmp;
        }

        System.out.println("Reversed Matrix");
        printMatrix(mtrx);
    }

    private void printMatrix(int[][] mtrx){
        for (int[] row : mtrx){
            System.out.println("R:"+Arrays.toString(row));
        }
    }
}
