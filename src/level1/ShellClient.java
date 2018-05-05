package level1;

import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * An automatic client that can communicate in the shell with a remote server.
 *
 * @author Niu Yunpeng
 */
public class ShellClient {
    private static final String SERVER_URL = "shell2017.picoctf.com";
    private static final int PORT = 14319;

    // The format of the expected string.
    private static final Pattern INPUT_FORMAT =
            Pattern.compile("Please give me the '(?<repeated>\\S)' character '(?<times>\\d+)' times, followed by a single '(?<single>\\S)'.");

    public static void main(String[] args) throws Exception {
        // Create a client and connect to the server.
        Socket client = new Socket(SERVER_URL, PORT);
        // Scanner to receive instructions from the server.
        Scanner scanner = new Scanner(client.getInputStream());
        // Writer to respond to the server
        PrintWriter writer = new PrintWriter(client.getOutputStream(), true);
        // Uses this variable to store the response text.
        String response = "";

        while (scanner.hasNext()) {
            String line = scanner.nextLine();
            System.out.println(line);

            // Tries to match the format of this current line.
            final Matcher matcher = INPUT_FORMAT.matcher(line);
            if (matcher.matches()) {
                final char repeated = matcher.group("repeated").charAt(0);
                final int times = Integer.parseInt(matcher.group("times"));
                final char single = matcher.group("single").charAt(0);
                response = buildResult(repeated, times, single);
            } else if (line.equals("Input:")) {
                writer.println(response);
                System.out.print(response);
            }
        }

        client.close();
        scanner.close();
        writer.close();
    }

    /**
     * Uses a `StringBuilder` to construct the response text.
     */
    private static String buildResult(char repeated, int times, char single) {
        StringBuilder builder = new StringBuilder();

        for (int i = 0; i < times; i++) {
            builder.append(repeated);
        }
        builder.append(single);

        return builder.toString();
    }
}
