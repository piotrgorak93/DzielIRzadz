package rmi.rmiTestServer;

import rmi.rmiTestMeeting.IMeeting;
import server.Matrix;

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
    public Matrix multMatrix(int m, int n, int p, int q) throws RemoteException {
        return new Matrix(m, n, p, q);
    }

    @Override
    public int[][] addMatrix(Matrix matrix1, Matrix matrix2) throws RemoteException {
        int[][] sum = new int[matrix1.matrixField.length][matrix2.matrixField.length];
        for (int c = 0; c < matrix1.matrixField.length; c++)
            for (int d = 0; d < matrix1.matrixField.length; d++)
                sum[c][d] = matrix1.matrixField[c][d] + matrix2.matrixField[c][d];  //replace '+' with '-' to subtract matrices
        return sum;
    }


}
