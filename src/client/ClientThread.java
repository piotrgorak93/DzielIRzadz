package client;

import rmi.rmiTestClient.MeetingClient;
import rmi.rmiTestMeeting.IMeeting;
import server.Matrix;

import java.rmi.RemoteException;

/**
 * @author Piotr Górak, Maciej Knicha³ dnia 2015-05-09.
 */
public class ClientThread implements Runnable {

    IMeeting meeting;
    Matrix resultAMulB;
    Matrix resultCMulD;

    @Override
    public void run() {
        meeting = new MeetingClient().connectToServer();
        try {
            System.out.println(meeting.writeServerResponse());
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        try {
            resultAMulB = meeting.multMatrix(40, 20, 20, 60);
            resultCMulD = meeting.multMatrix(60, 60, 60, 40);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        System.out.println("A*B");

        System.out.println(resultAMulB.matrixToString());
        System.out.println("C*D");
        System.out.println(resultCMulD.matrixToString());
    }
}
