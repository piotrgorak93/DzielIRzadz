package server;

import java.io.Serializable;
import java.util.Random;
import java.util.Scanner;

public class Matrix implements Serializable {
    public int[][] matrixField;

    public Matrix(int m, int n, int p, int q) {
        main(m, n, p, q);
    }

    public int[][] main(int m, int n, int p, int q) {
        int sum = 0, c, d, k;

        Scanner in = new Scanner(System.in);
//        System.out.println("Enter the number of rows and columns of first matrix");
        Random rand = new Random();


        int first[][] = new int[m][n];

        System.out.println("Enter the elements of first matrix");

        for (c = 0; c < m; c++)
            for (d = 0; d < n; d++)
                first[c][d] = rand.nextInt((10) + 1);

        System.out.println("Enter the number of rows and columns of second matrix");


        if (n != p)
            System.out.println("Matrices with entered orders can't be multiplied with each other.");
        else {
            int second[][] = new int[p][q];
            int multiply[][] = new int[m][q];

            System.out.println("Enter the elements of second matrix");

            for (c = 0; c < p; c++)
                for (d = 0; d < q; d++)
                    second[c][d] = rand.nextInt((10) + 1);

            for (c = 0; c < m; c++) {
                for (d = 0; d < q; d++) {
                    for (k = 0; k < p; k++) {
                        sum = sum + first[c][k] * second[k][d];
                    }

                    multiply[c][d] = sum;
                    sum = 0;
                }
            }

            System.out.println("Product of entered matrices:-");

            for (c = 0; c < m; c++) {
                for (d = 0; d < q; d++)
                    System.out.print(multiply[c][d] + "\t");

                System.out.print("\n");
            }
            matrixField = multiply;
            return multiply;
        }
        return null;
    }

    public String matrixToString() {
        String toReturn = "";
        for (int[] ints : matrixField) {
            for (int anInt : ints) {
                toReturn += anInt;
                toReturn += "\t";
            }
            toReturn += "\n";

        }
        return toReturn;

    }
}