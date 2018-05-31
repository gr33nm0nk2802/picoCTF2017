package cross;

import java.io.PrintWriter;
import java.net.Socket;
import java.util.Random;
import java.util.Scanner;

/**
 * An automatic client that can communicate in the shell with a remote server.
 *
 * @author Niu Yunpeng
 */
public class ShellClient {
    private static final String SERVER_URL = "ctf.pwn.sg";
    private static final int PORT = 1400;

    public static void main(String[] args) throws Exception {
        // Create a client and connect to the server.
        Socket client = new Socket(SERVER_URL, PORT);
        // Scanner to receive instructions from the server.
        Scanner scanner = new Scanner(client.getInputStream());
        // Writer to respond to the server
        PrintWriter writer = new PrintWriter(client.getOutputStream(), true);
        // A random number generator.
        Random generator = new Random();


        // To record the options.
        String[] options = new String[10];
        boolean optionsBegin = false;
        int numOfOptions = 0;

        while (scanner.hasNext()) {
            String line = scanner.nextLine();
            System.out.println(line);

            // There is a new set of options coming.
            if (line.equals("Where would you like to move?")) {
                optionsBegin = true;
            } else if (line.equals("9 -- Quit")) {
                // Give response here.
                String option = options[generator.nextInt(numOfOptions)];
                writer.println(option);
                System.out.println(option);

                optionsBegin = false;
                numOfOptions = 0;
            } else if (optionsBegin) {
                options[numOfOptions++] = line.substring(0, 1);
            }
        }

        client.close();
        scanner.close();
        writer.close();
    }
}
