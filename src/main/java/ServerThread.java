import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerThread implements Runnable{
    private ServerSocket serverSocket;
    private final int port;

    public ServerThread(int port) {
        this.port = port;
    }

    public void run() {
        try {
            serverSocket = new ServerSocket(this.port);

            while (true) {
                Socket clientSocket = serverSocket.accept();
                new Thread(new ServerConnectionThread(clientSocket)).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
            return;
        }
    }
}
