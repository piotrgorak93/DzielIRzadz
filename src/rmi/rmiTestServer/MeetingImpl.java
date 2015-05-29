package rmi.rmiTestServer;

import rmi.rmiTestMeeting.IMeeting;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

public class MeetingImpl extends UnicastRemoteObject implements IMeeting {
    private static final long serialVersionUID = 1L;
    ArrayList<int[][]> listaMacierzyServer = new ArrayList<>();

    public MeetingImpl() throws RemoteException {

    }

    @Override
    public String writeServerResponse() throws RemoteException {
        return "Witaj na serwerze";
    }

    @Override
    public void sendToServer(int[][] matrix) throws RemoteException {
        listaMacierzyServer.add(matrix);
    }

    @Override
    public void printMatrixFromServer() {
        for (int[][] ints : listaMacierzyServer) {
            System.out.println(ints);
        }
    }

    @Override
    public int[][] addTwoMatrixes(int[][] first, int[][] second) {
        int[][] sum = new int[0][];
        for (int i = 0; i < first.length; i++)
            for (int j = 0; j < second.length; j++)
                sum[i][j] = first[i][j] + second[i][j];

        System.out.println("Sum of entered matrices:-");

        for (int i = 0; i < sum.length; i++) {
            for (int j = 0; j < sum.length; j++)
                System.out.print(sum[i][j] + "\t");

            System.out.println();
        }
        return sum;
    }

}
