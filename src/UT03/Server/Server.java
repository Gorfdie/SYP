package UT03.Server;

import UT03.Client.Interfaces.ClientCallback;

import java.net.*;
import java.io.*;
public class Server implements ClientCallback {
    ServerWindow serverWindow;

    public Server(){
        serverWindow = new ServerWindow();
    }

    public void start() {
        int port = 2050;
        serverWindow.setVisible(true);
        ServerSocket serverSocket = null;
        Socket socket = null;

        try {
            serverSocket = new ServerSocket(port);
        } catch (IOException e) {
            e.printStackTrace();

        }
        while (true) {
            try {
                socket = serverSocket.accept();
            } catch (IOException e) {
                System.out.println("I/O error: " + e);
            }
            // new thread for a client
            new ServerThread(socket, this).start();
        }
    }

    @Override
    public void onMessage(String message) {
        serverWindow.addText(message);
        serverWindow.setVisible(true);
    }
}

//        while (true) {
//            try {
//                serverSocket = serverSocket.accept();
//            } catch (IOException e) {
//                System.out.println("I/O error: " + e);
//            }
//            // new thread for a client
//            new ServerThread(serverSocket).start();
//        }
//        while (true) {
//            try {
//                Socket clientSocket = serverSocket.accept();
//
//                BufferedReader in = new BufferedReader(new
//                        InputStreamReader(clientSocket.getInputStream()));
//                String inputLine = in.readLine();
//
//                System.out.println( "Servidor recibe: " + inputLine );
//                serverWindow.addText(inputLine);
//                serverWindow.setVisible(true);
//                in.close();
//                clientSocket.close();
//                serverSocket.close();
//
//            } catch (UnknownHostException e) {
//                System.out.println("ERROR UnknowHost Exception: " + e);
//                break;
//            } catch (IOException e) {
//                e.printStackTrace();
//                System.out.println("ERROR IO Exception: " + e);
//                break;
//            }
//        }
