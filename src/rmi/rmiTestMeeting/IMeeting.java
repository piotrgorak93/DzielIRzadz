package rmi.rmiTestMeeting;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface IMeeting extends Remote {
    String writeServerResponse() throws RemoteException;

    void sendToServer(int[][] matrix) throws RemoteException;

    void printMatrixFromServer() throws RemoteException;

    int[][] addTwoMatrixes(int[][] first, int[][] second) throws RemoteException;
}