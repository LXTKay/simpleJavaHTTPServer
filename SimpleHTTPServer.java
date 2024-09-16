import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.ServerSocket; //Creates server with port as qrgument
import java.net.Socket;
import java.io.IOException;

public class SimpleHTTPServer {

  public static void main(String[] args) throws IOException {
    final ServerSocket server = new ServerSocket(8080);
    try {
      System.out.println("Listening for connection on port 8080 ....");
      while (true) {
        Socket clientSocket = server.accept();

        InputStreamReader isr = new InputStreamReader(clientSocket.getInputStream());
        BufferedReader reader = new BufferedReader(isr);

        String line = reader.readLine();
        while (!line.isEmpty()) {
          System.out.println(line);
          line = reader.readLine();
        }
      }
    } finally {
      server.close();
    }
  }

}