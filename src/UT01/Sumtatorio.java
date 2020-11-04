package UT01;

public class Sumtatorio {
    public int sumar(int num1, int num2) {
        int minimo = Math.min(num1, num2);
        int maximo = Math.max(num1, num2);
        int suma = 0;
        for (int i = minimo; i <= maximo; i++) {
            suma += i;
        }
        return suma;
    }
}
