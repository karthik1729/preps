package io.alphadevs;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;

public class Main {
    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(8080);
            System.out.println("Server Started");
            while (true){
                Socket clientSocket = serverSocket.accept();
                InputStreamReader isr =  new InputStreamReader(clientSocket.getInputStream());
                BufferedReader reader = new BufferedReader(isr);
                String line = reader.readLine();
                while (!line.isEmpty()) {
                    System.out.println(line);
                    line = reader.readLine();
                }
                String httpResponse = "HTTP/1.1 200 OK\r\n\r\n" + new Date();
                clientSocket.getOutputStream().write(httpResponse.getBytes("UTF-8"));
                clientSocket.close();
                System.out.println("Responded");
            }


        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
