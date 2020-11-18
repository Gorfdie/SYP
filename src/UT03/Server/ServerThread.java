package UT03.Server;

import UT03.Client.Interfaces.ClientCallback;

import java.io.*;
import java.net.Socket;

public class ServerThread extends Thread {
    protected Socket socket;
    ClientCallback clientCallback;

    public ServerThread(Socket clientSocket, ClientCallback clientCallback) {
        this.socket = clientSocket;
        this.clientCallback = clientCallback;
    }

    public void run() {
        InputStream inp = null;
        BufferedReader brinp = null;
        try {
            inp = socket.getInputStream();
            brinp = new BufferedReader(new InputStreamReader(inp));
        } catch (IOException e) {
            return;
        }
        String line;
        while (true) {
            try {
                line = brinp.readLine();
                if ((line == null) || line.equalsIgnoreCase("QUIT")) {
                    socket.close();
                    return;
                } else {
                    System.out.println( "Servidor recibe: " + line );
                    this.clientCallback.onMessage(line);

                }
            } catch (IOException e) {
                e.printStackTrace();
                return;
            }
        }
    }
}
