package RepasoThreads;

import java.util.Random;

public class TakeAnumber {
    int turn=0;
    int ticketMachine=0;

    public synchronized void takeNumber(ClientRun client) {
        ticketMachine++;
        client.setNumber(ticketMachine);
        System.out.println("The client "+Thread.currentThread().getName()+" takes ticket number: "+client.getNumber());

    }

    public synchronized void cook() throws InterruptedException {
        while (ticketMachine==0 || ticketMachine<turn){
            System.out.println("Clerk is waiting: no clients to serve");
            wait();
        }
        turn++;
        notifyAll();
    }

    public synchronized int getTurn() {
        return turn;
    }

    public synchronized void takeOrder (ClientRun client) throws InterruptedException {
        while (!(client.getNumber()==turn+1)){
            wait();
        }

        System.out.println("the client with number "+client.getNumber()+" is taking the bread");
        notifyAll();

    }

}
