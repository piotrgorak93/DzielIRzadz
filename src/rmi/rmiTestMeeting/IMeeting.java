package rmi.rmiTestMeeting;

import server.Matrix;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface IMeeting extends Remote {
    String writeServerResponse() throws RemoteException;

    Matrix multMatrix(int m, int n, int p, int q) throws RemoteException;

    int[][] addMatrix(Matrix matrix1, Matrix matrix2) throws RemoteException;

    int[][] performFinalMul(int[][] sumFirst, int[][] e) throws RemoteException;
}