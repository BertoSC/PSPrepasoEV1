package RepasoThreads;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.concurrent.*;

public class MainPalindrome {
    private final static String[] PALINDROMES = {
            "kayak",
            "deified",
            "rotators",
            "repaper",
            "deed",
            "peeps",
            "wow",
            "noons",
            "civic",
            "racecar",
            "level",
            "mom"
    };

    // VERSIÓN CON O SIN POOL
    // CON THREADS > NECESITAS FUTURE TASK (ej: new Thread (futuretask));
    // CON POOL > NECESITAS FUTURE y utilizar submit(Callable cal) ej: Future f= pool.submit (callable obj);

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService pool = Executors.newFixedThreadPool(5);
        //HashSet<FutureTask> results = new HashSet<>();
        HashSet<Future> futures = new HashSet<>();
       /*

        for (int i =0; i<PALINDROMES.length; i++){
            CallablePalindrome cal = new CallablePalindrome(PALINDROMES[i]);
            results.add(new FutureTask<>(cal));
        }

        for (FutureTask f: results){
            Thread th = new Thread(f);
            th.start();
        }

        for (FutureTask f: results){
            try {
                System.out.println(f.get());
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            } catch (ExecutionException e) {
                throw new RuntimeException(e);
            }
        }
        */

        for (int i =0; i<PALINDROMES.length; i++){
            CallablePalindrome cal = new CallablePalindrome(PALINDROMES[i]);
            futures.add(pool.submit(cal));
        }

        for (Future f:futures){
            System.out.println(f.get());
        }

        pool.shutdown();


    }

}
