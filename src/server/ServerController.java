package server;

/**
 * @author Piotr Górak, Maciej Knicha³ dnia 2015-05-09.
 */
public class ServerController {
    public static void main(String[] args) {
//        new Matrix(40, 20, 20, 80);
        new Thread(new ServerThread()).start();
    }
}
