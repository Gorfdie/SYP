package Testing;

public class PrimerHilo extends Thread {
    private int x;
    public PrimerHilo(int x) {
        this.x = x;
    }
    public void run() {
        for (int i = 0; i < x; i++)
            System.out.println("En el hilo..." + i);
    }
    public static void main(String[] args) {
        PrimerHilo h = new PrimerHilo(5);
        h.start();
    }
}