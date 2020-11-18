package UT02;

public class Cajero {

    private int saldo;
    private boolean disponible = true;
    private boolean bloqueada = false;

    public Cajero(int saldoInicial) {
        this.saldo = saldoInicial;
        System.out.println("Saldo inicial: " + saldoInicial);
    }

    public synchronized int retirar(int valor) throws OperationException {
        int saldo = this.getSaldo();
        System.out.println("Saldo actual: " + saldo);
        if (valor > saldo || saldo == 0 || bloqueada) {
            bloqueada = true;
            throw new OperationException();
        }
//        while (!disponible) {
//            try {
//                wait();
//            } catch (InterruptedException e) {
//            }
//        }
        saldo = saldo - valor;
        this.setSaldo(saldo);
//        disponible = true;
//        notifyAll();
        return saldo;
    }
    public synchronized int ingresar(int valor) throws OperationException {
        int saldo = this.getSaldo();
        System.out.println("Saldo actual: " + saldo);
        if (saldo == 0 || bloqueada) {
            bloqueada = true;
            throw new OperationException();
        }
//        while (!disponible) {
//            try {
//                wait();
//            } catch (InterruptedException e) {
//            }
//        }
        saldo = saldo + valor;
        this.setSaldo(saldo);
//        disponible = true;
//        notifyAll();
        return saldo;
    }

    public int getSaldo() {
        return saldo;
    }

    public void setSaldo(int saldo) {
        this.saldo = saldo;
    }
}
