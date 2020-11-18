package UT02;

import java.util.Random;

public class Retirar extends Thread {
    private Cajero cajero;
    private int id;
    private int retirado;
    public Retirar(Cajero cajero, int id) {
        this.cajero = cajero;
        this.id = id;
    }
    public void run() {
        for (int i = 0; i > -1; i++) {
        int valor = new Random().nextInt(((20 - 5) + 1) + 5);
        int saldo;
            try {
                saldo = cajero.retirar(valor);
                retirado = retirado + valor;
            } catch (OperationException e) {
                System.out.println("El retirador "+ id +" ha retirado: " + retirado + "€");
                interrupt();
                break;
            }
            System.out.println(i + " => Retirador " + id + ", retira: "+ valor + ", Saldo: " + saldo);
        }
    }
}
