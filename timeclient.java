package times;

import java.io.*;
import java.net.*;

public class timeclient {
    public static void main(String[] args) {
        if (args.length != 2) {
            System.out.println("Usage: java timeclient <server-ip> <port>");
            return;
        }

        String serverIp = args[0];
        int port = Integer.parseInt(args[1]);

        try (Socket socket = new Socket(serverIp, port)) {
            InputStream input = socket.getInputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(input));

            String serverTime = reader.readLine();
            System.out.println("Server time: " + serverTime);
        } catch (UnknownHostException ex) {
            System.out.println("Server not found: " + ex.getMessage());
        } catch (IOException ex) {
            System.out.println("I/O error: " + ex.getMessage());
        }
    }
}

