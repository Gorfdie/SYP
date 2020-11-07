package UT02;

public class Cajero {
    public int saldo;
    private boolean disponible = true;
    private boolean bloqueada = false;

    public Cajero(int saldoInicial) {
        this.saldo = saldoInicial;
        System.out.println("Saldo inicial: " + saldoInicial);
    }

    public synchronized void retirar(int valor) throws OperationException {
        if (valor > saldo || saldo == 0 || bloqueada) {
            bloqueada = true;
            throw new OperationException();
        }
        while (!disponible) {
            try {
                wait();
            } catch (InterruptedException e) {
            }
        }
        saldo = saldo - valor;
        disponible = true;
        notifyAll();
    }
    public synchronized void ingresar(int valor) throws OperationException {
        if (saldo == 0 || bloqueada) {
            bloqueada = true;
            throw new OperationException();
        }
        while (!disponible) {
            try {
                wait();
            } catch (InterruptedException e) {
            }
        }
        saldo = valor + saldo;
        disponible = true;
        notifyAll();
    }
}
