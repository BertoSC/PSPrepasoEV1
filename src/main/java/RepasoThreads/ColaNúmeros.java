package RepasoThreads;

import java.util.LinkedList;
import java.util.Random;

public class ColaNúmeros {
    LinkedList<Integer> colaNumeros = new LinkedList<>();


    public synchronized void producirNumero() {
        while (colaNumeros.size()==5){
            try {
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

        Random rm = new Random();
        int numero= rm.nextInt(1, 101);
        colaNumeros.add(numero);
        System.out.println("El productor crea el número: "+numero);
        notifyAll();
    }

    public synchronized void imprimirNUmero() {
        while (colaNumeros.isEmpty()){
            try {
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

        for (int num:colaNumeros){
            System.out.println("El consumidor ha consumido el número: "+num);
        }
        colaNumeros.clear();
        notifyAll();

    }


}
