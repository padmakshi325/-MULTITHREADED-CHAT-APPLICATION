import java.io.*;
import java.net.*;

public class Client {
    private static final String SERVER_ADDRESS = "127.0.0.1";
    private static final int PORT = 12345;

    public static void main(String[] args) {
        try {
            Socket socket = new Socket(SERVER_ADDRESS, PORT);
            System.out.println("✅ Connected to the chat server.");

            new Thread(new ReceiveMessages(socket)).start();

            try (
                BufferedReader console = new BufferedReader(new InputStreamReader(System.in));
                PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            ) {
                String input;
                while ((input = console.readLine()) != null) {
                    out.println(input);
                }
            }
        } catch (IOException e) {
            System.out.println("❌ Could not connect to server: " + e.getMessage());
            e.printStackTrace();
        }
    }

    private static class ReceiveMessages implements Runnable {
        private Socket socket;

        public ReceiveMessages(Socket socket) {
            this.socket = socket;
        }

        public void run() {
            try (
                BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            ) {
                String msg;
                while ((msg = in.readLine()) != null) {
                    System.out.println("Server: " + msg);
                }
            } catch (IOException e) {
                System.out.println("❌ Connection to server lost.");
            }
        }
    }
}
