package RepasoThreads;

import java.util.Random;

public class CreadorNumero implements Runnable{
    ColaNúmeros cola;
    int veces=0;

    public CreadorNumero(ColaNúmeros cola){
        this.cola=cola;
    }
    @Override
    public void run() {
        while(veces<100) {
            cola.producirNumero();
            veces++;
        }
        System.out.println("El creador ha acabado con veces: "+veces);
    }
}
