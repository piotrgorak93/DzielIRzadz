package rmi.rmiTestMeeting;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface IMeeting extends Remote {
    String writeServerResponse() throws RemoteException;


}