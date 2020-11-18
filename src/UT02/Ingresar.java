package UT02;

public class Ingresar extends Thread {
    private Cajero cajero;
    private int ingresado;
    public Ingresar( Cajero cajero ) {
        this.cajero = cajero;
    }
    public void run() {
        for (int i = 0; i > -1; i++) {
            int saldo;
            try {
                saldo = cajero.ingresar(10);
                ingresado += 10;
            } catch (OperationException e) {
                System.out.println("El ingresador ha ingresado: " + ingresado + "€");
                interrupt();
                break;
            }
            System.out.println(i + " => Ingresador: ingresa 10, saldo: " + saldo);
        }
    }
}
