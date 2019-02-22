package io.alphadevs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;

public class MainServerWithThreads {
    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(8080);
            System.out.println("Server Started");
            while (true) {
                final Socket clientSocket = serverSocket.accept();
                Thread thread = new Thread() {
                    @Override
                    public void run() {
                        try {
                            Thread.sleep(3000);
                            String httpResponse = "HTTP/1.1 200 OK\r\n\r\n" + new Date();
                            clientSocket.getOutputStream().write(httpResponse.getBytes("UTF-8"));
                            clientSocket.close();
                            System.out.println("Responded");
                        } catch (IOException e) {
                            e.printStackTrace();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                };
                thread.start();
            }


        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
