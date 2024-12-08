package RepasoThreads;

import java.util.Random;

public class ClerkRun implements Runnable{
    TakeAnumber takeAnumber;

    public ClerkRun(TakeAnumber take){
        this.takeAnumber=take;
    }

    @Override
    public void run() {
        try {
            while (takeAnumber.getTurn()<=100) {
                Random rm = new Random();
                int preparingBread = rm.nextInt(1, 1001);
                Thread.sleep(preparingBread);
                takeAnumber.cook();
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }
}
