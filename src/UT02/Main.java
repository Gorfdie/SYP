package UT02;


public class Main {

    public static void main(String[] args) {
        Cajero cajero = new Cajero(100);
        Ingresar ingresador = new Ingresar(cajero);
        Retirar retirador1 = new Retirar(cajero, 1);
        Retirar cretirador2 = new Retirar(cajero, 2);
        ingresador.start();
        retirador1.start();
        cretirador2.start();
    }
}
