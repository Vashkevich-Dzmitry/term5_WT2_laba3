package by.vashket.labs.server.socketLayer;

import by.vashket.labs.server.controller.Controller;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class ArchiveServer {
    private static Socket clientSocket;
    private static ServerSocket server;
    private static Scanner in;
    private static PrintWriter out;
    private static Controller controller = Controller.getInstance();

    public static void main(String[] args) {
        try {
            try {
                server = new ServerSocket(8082);
                clientSocket = server.accept();
                try {
                    in = new Scanner(clientSocket.getInputStream());
                    out = new PrintWriter(clientSocket.getOutputStream());

                    String request = in.nextLine();
                    String response;
                    while (request != null) {
                        System.out.println(request);

                        response = controller.executeTask(request);

                        out.println(response);
                        out.flush();
                        request = in.nextLine();
                    }

                } finally {
                    clientSocket.close();
                    in.close();
                    out.close();
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            } finally {
                System.out.println("Сервер закрыт!");
                server.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
