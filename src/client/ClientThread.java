package client;

import rmi.rmiTestClient.MeetingClient;
import rmi.rmiTestMeeting.IMeeting;

import java.rmi.RemoteException;
import java.util.HashMap;
import java.util.Random;

/**
 * @author Piotr Górak, Maciej Knicha³ dnia 2015-05-09.
 */
public class ClientThread implements Runnable {

    IMeeting meeting;
    HashMap<int[], int[][]> listaMacierzy = new HashMap<>();

    @Override
    public void run() {
        meeting = new MeetingClient().connectToServer();
        try {
            System.out.println(meeting.writeServerResponse());
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        //A
        listaMacierzy.put(new int[]{60, 20}, createMatrix(60, 20));
        //B
        listaMacierzy.put(new int[]{20, 40}, createMatrix(20, 40));
        //C
        listaMacierzy.put(new int[]{60, 60}, createMatrix(60, 60));
        //D
        listaMacierzy.put(new int[]{60, 40}, createMatrix(60, 40));
        //E
        listaMacierzy.put(new int[]{40, 60}, createMatrix(40, 60));


        try {
            meeting.addTwoMatrixes(listaMacierzy.get("A"), listaMacierzy.get("B"));
        } catch (RemoteException e) {
            e.printStackTrace();

        }

        try {
            meeting.printMatrixFromServer();
        } catch (RemoteException e) {
            e.printStackTrace();
        }

    }

    public int[][] createMatrix(int h, int w) {
        int[][] matrix = new int[h][w];
        Random rand = new Random();

        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                matrix[i][j] = rand.nextInt((99) + 1);
            }
        }
        printMatrix(matrix, h, w);
        return matrix;
    }

    public void printMatrix(int[][] matrix, int h, int w) {
        System.out.println("-----------------------");
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                if (j == w - 1) {
                    System.out.println(matrix[i][j] + " ");
                } else {
                    System.out.print(matrix[i][j] + " ");
                }
            }

        }
    }
}
