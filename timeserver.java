package times;

import java.io.*;
import java.net.*;
import java.text.SimpleDateFormat;
import java.util.Date;

public class timeserver {
    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println("Usage: java timeserver <port>");
            return;
        }

        int port = Integer.parseInt(args[0]);

        try (ServerSocket serverSocket = new ServerSocket(port)) {
            System.out.println("Server is listening on port " + port);

            while (true) {
                try (Socket socket = serverSocket.accept()) {
                    System.out.println("New client connected");

                    OutputStream output = socket.getOutputStream();
                    PrintWriter writer = new PrintWriter(output, true);

                    String currentTime = new SimpleDateFormat("dd.MM.yyyy HH:mm").format(new Date());
                    writer.println(currentTime);

                    System.out.println("Sent date and time: " + currentTime);
                } catch (IOException ex) {
                    System.out.println("Error handling client connection: " + ex.getMessage());
                    ex.printStackTrace();
                }
            }
        } catch (IOException ex) {
            System.out.println("Server error: " + ex.getMessage());
            ex.printStackTrace();
        }
    }
}
