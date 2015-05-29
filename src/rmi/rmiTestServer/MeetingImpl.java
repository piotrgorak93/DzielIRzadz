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



}
