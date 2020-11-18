package UT03.Client;

public class ClientMain {
    public static void main(String[] args){
        Client cliente1 = new Client(1);
        Client cliente2 = new Client(2);
        Client cliente3 = new Client(3);
        cliente1.mandarMensaje();
        cliente1.closeAll();
        cliente2.mandarMensaje();
        cliente2.closeAll();
        cliente3.mandarMensaje();
        cliente3.closeAll();
    }
}
