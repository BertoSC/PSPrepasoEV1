package RepasoThreads;

import java.util.Random;

public class MainTemp {
    private final static int YEARS = 10;
    private final static int DAYS = 365;
    private final static int MIN_TEMP = -30;
    private final static int MAX_TEMP = 51;

    public static void main(String[] args) {
        Random rm = new Random();
        int [][] temperatures = new int [YEARS][DAYS];
        Thread [] threads = new Thread[YEARS];
        RunnableSumTemperature [] runnables = new RunnableSumTemperature[YEARS];
        int totalSum=0;

        for (int i=0; i<YEARS; i++){
            for (int j=0; j<DAYS;j++){
                temperatures[i][j]=rm.nextInt(MIN_TEMP,MAX_TEMP);

            }
        }

        for (int y=0; y<YEARS;y++){
            runnables[y]=new RunnableSumTemperature(temperatures[y]);
            threads[y]=new Thread(runnables[y]);
            threads[y].start();

        }

        for (int r=0; r<YEARS;r++){
            try {
                threads[r].join();
                totalSum+=runnables[r].getSum();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

        double media = (double)totalSum/3650;
        String finalMed = String.format("%.2f", media);

        System.out.println("La media de temperaturas de los últimos 10 años es: "+finalMed);

    }

}
