package RepasoThreads;

public class MainMessage {
    public static void main(String[] args) {
        RunnableMessage rn = new RunnableMessage();
        Thread th1 = new Thread(rn);
        Thread th2 = new Thread(rn);

        th1.start();
        th2.start();

        try {
            th1.join();
            th2.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }


    }
}
