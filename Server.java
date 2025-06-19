import java.io.*;
import java.net.*;

public class Server {
    public static void main(String[] args) {
        System.out.println("🔄 Starting server...");

        try (
            ServerSocket serverSocket = new ServerSocket(12345, 50, InetAddress.getByName("127.0.0.1"))
        ) {
            System.out.println("✅ Server is listening on " + serverSocket.getInetAddress().getHostAddress() + ":" + serverSocket.getLocalPort());
            Socket clientSocket = serverSocket.accept();
            System.out.println("🎉 Client connected: " + clientSocket.getInetAddress().getHostAddress());

            BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
            BufferedReader keyboard = new BufferedReader(new InputStreamReader(System.in));

            String message;
            while ((message = in.readLine()) != null) {
                System.out.println("Client: " + message);
                System.out.print("You: ");
                String reply = keyboard.readLine();
                out.println(reply);
            }

            clientSocket.close();
            System.out.println("❎ Client disconnected.");
        } catch (IOException e) {
            System.out.println("❌ Server failed: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
