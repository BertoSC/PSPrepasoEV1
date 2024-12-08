package RepasoThreads;

import java.util.Random;

public class ClientRun implements Runnable{
    int number;
    TakeAnumber takeAnumber;

    public ClientRun(TakeAnumber take){
        this.takeAnumber=take;
    }

    public synchronized void setNumber(int number) {
        this.number = number;
    }

    public synchronized int getNumber() {
        return number;
    }

    @Override
    public void run() {
        Random rm = new Random();
        int wait = rm.nextInt( 2000, 4000 );
        try {
            Thread.sleep(wait);
            takeAnumber.takeNumber(this);
            takeAnumber.takeOrder(this);

        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }
}
