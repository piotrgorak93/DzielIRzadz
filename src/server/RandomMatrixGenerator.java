package server;

import java.util.Random;

/**
 * @author Piotr Górak, Maciej Knicha³ dnia 2015-05-29.
 */
public class RandomMatrixGenerator {

    private final int[][] first;

    public RandomMatrixGenerator(int m, int n) {
        Random rand = new Random();
        first = new int[m][n];

        for (int c = 0; c < m; c++)
            for (int d = 0; d < n; d++)
                first[c][d] = rand.nextInt((10) + 1);
    }

    public int[][] getResult() {
        return first;
    }
}
