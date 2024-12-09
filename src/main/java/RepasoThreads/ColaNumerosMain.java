package RepasoThreads;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ColaNumerosMain {
    public static void main(String[] args) throws InterruptedException {

        ColaNúmeros cola = new ColaNúmeros();

        CreadorNumero creador = new CreadorNumero(cola);
        ConsumidorNumero consumidor = new ConsumidorNumero(cola);

        ExecutorService pool = Executors.newFixedThreadPool(2);

        pool.execute(creador);
        pool.execute(consumidor);

        pool.shutdown();


    }


}
