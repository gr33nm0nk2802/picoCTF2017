package level1;

import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class WorldChat {
    private static final String SERVER_URL = "shell2017.picoctf.com";
    private static final int PORT = 31955;

    public static void main(String[] args) throws Exception {
        // Create a client and connect to the server.
        Socket client = new Socket(SERVER_URL, PORT);
        // Scanner to receive instructions from the server.
        Scanner scanner = new Scanner(client.getInputStream());
        // Writer to respond to the server
        PrintWriter writer = new PrintWriter(client.getOutputStream(), true);

        while (scanner.hasNext()) {
            String line = scanner.nextLine();

            if (line.contains("flagperson")) {
                System.out.println(line);
            }
        }

        client.close();
        scanner.close();
        writer.close();
    }
}
