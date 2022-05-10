public class Main {
    public static void main(String[] args) {
        ServerThread server = new ServerThread(6000);
        new Thread(server).start();
    }
}
