package Testing;

public class HiloEjemplo1 extends Thread {
    private int contador; // Contador de cada hilo
    private int hilo;
    public HiloEjemplo1(int hilo) {
        this.hilo = hilo;
        System.out.println("CREANDO HILO: " + hilo);
    }
    public void run() {
        for (contador = 0; contador < 5; contador++)
            System.out.println("Hilo: " + hilo + " C = " + contador);
    }
    public static void main(String[] args) {
        HiloEjemplo1 ej = null;
        for(int i = 0; i < 5; i++) {
            ej = new HiloEjemplo1(i);
            ej.start();
        }
        System.out.println("5 HILOS CREADOS");
    }
}