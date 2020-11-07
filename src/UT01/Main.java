package UT01;

public class Main {

    public static void main(String[] args) {
        LanzarSumador lanzarSumador = new LanzarSumador();
        lanzarSumador.Sumar(1,30);
        System.out.println(lanzarSumador.Sumar(1,30));
        lanzarSumador.Sumar(70, 100);
        System.out.println(lanzarSumador.Sumar(70, 100));
    }
}
