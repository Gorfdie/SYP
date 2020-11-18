package UT03.Client;

import java.io.*;
import java.net.*;



public class Client
{
    private Socket clientSocket;
    private PrintWriter out;
    private int id;
    public Client(int id) {
        this.id = id;
        int port=2050;
        try {
            this.clientSocket = new Socket("localhost", port);
            this.out = new PrintWriter(clientSocket.getOutputStream(), true);
        } catch (UnknownHostException e) {
            System.out.println("UnknownHostException " + e);
        } catch (IOException e) {
            System.out.println("IOException : " + e);
        }
    }


    public void mandarMensaje()
    {
        try {
            System.out.println("Inserte su mensaje cliente nº" + this.id);
            BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
            String text = "Cliente " + this.id + " envia: " +  in.readLine();
            System.out.println(text);
            this.out.println(text);
            clearConsole();
        } catch (UnknownHostException e) {
            System.out.println("UnknownHostException " + e);
        } catch (IOException e) {
            System.out.println("IOException : " + e);
        }

    }

    public void closeAll() {
        try {
            this.out.close();
            this.clientSocket.close();
        } catch (UnknownHostException e) {
            System.out.println("UnknownHostException " + e);
        } catch (IOException e) {
            System.out.println("IOException : " + e);
        }
    }

    private final static void clearConsole()
    {
        try
        {
            final String os = System.getProperty("os.name");

            if (os.contains("Windows"))
            {
                Runtime.getRuntime().exec("cls");
            }
            else
            {
                Runtime.getRuntime().exec("clear");
            }
        }
        catch (final Exception e)
        {
            //  Handle any exceptions.
        }
    }

}