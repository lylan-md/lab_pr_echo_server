import java.io.*;
import java.net.Socket;

public class ServerConnectionThread implements Runnable {
    private final Socket socket;

    public ServerConnectionThread(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        BufferedOutputStream printWriter;
        BufferedReader bufferedReader;

        try {
            printWriter = new BufferedOutputStream(socket.getOutputStream());
            bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            printWriter.write("Hello client!\r\n".getBytes());
            printWriter.flush();
        } catch (IOException e) {
            e.printStackTrace();
            return;
        }

        while (true) {
            try {
                String line = bufferedReader.readLine();
                printWriter.write(line.getBytes());
                printWriter.write("\r\n".getBytes());
                printWriter.flush();
            } catch (IOException e) {
                break;
            }
        }
    }
}
