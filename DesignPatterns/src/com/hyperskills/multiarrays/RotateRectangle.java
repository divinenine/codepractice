package com.hyperskills.multiarrays;

import java.util.Arrays;
import java.util.Scanner;

public class RotateRectangle {

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int m = scn.nextInt();

        int [][] rectangle = new int[n][m];

        for (int i = 0; i < n; i++) {
            for (int k = 0; k < m; k++) {
                rectangle[i][k] = scn.nextInt();
            }
        }

        int [][] rotatedRectangle = new int[m][n];

        for (int i = 0; i < m; i++) {
            for (int k = 0, j = rectangle.length - 1; k < n; k++, j--) {
                rotatedRectangle[i][k] = rectangle [j][i];
            }
        }

/*        for (int[] vector : rectangle) {
            System.out.println(Arrays.toString(vector));
        }

        for (int[] vector : rotatedRectangle) {
            System.out.println(Arrays.toString(vector));
        }*/

        for (int i = 0; i < rotatedRectangle.length; i++) {
            for (int k = 0; k < rotatedRectangle[i].length; k++) {
                if (k == rotatedRectangle[i].length - 1) {
                    System.out.print(rotatedRectangle[i][k]);
                    break;
                }
                System.out.print(rotatedRectangle[i][k] + " ");

            }
            System.out.println();
        }

    }

}
