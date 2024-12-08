package RepasoThreads;

import java.util.Random;

public class RunnableMessage implements Runnable{
    @Override
    public void run() {
        Random rm = new Random();
        for (int i =0; i<5;i++) {
            System.out.println("Hello, my name is: " + Thread.currentThread().getName());
        }
        int delay = rm.nextInt(1000, 3000);
        try {
            Thread.sleep(delay);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Im "+Thread.currentThread().getName()+"! BYE BYE!!");

    }
}
