package RepasoThreads;

public class BakeryMain {
    public static void main(String[] args) {
        TakeAnumber tk = new TakeAnumber();

        ClerkRun clerk = new ClerkRun(tk);
        System.out.println("BAKERY STARTS WORKING");
        Thread thBaker = new Thread(clerk);
        thBaker.start();

        for (int i=1; i<=100; i++){
            ClientRun c = new ClientRun(tk);
            Thread client = new Thread(c);
            client.start();
        }

    }
}
