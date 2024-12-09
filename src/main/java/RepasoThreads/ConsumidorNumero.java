package RepasoThreads;

public class ConsumidorNumero implements Runnable {
    ColaNúmeros cola;
    int veces=0;

    public ConsumidorNumero(ColaNúmeros cola){
        this.cola=cola;
    }

    @Override
    public void run() {
        while(veces<20){
            cola.imprimirNUmero();
            veces++;
        }
        System.out.println("El consumidor ha acabado con veces: "+veces);

    }
}
