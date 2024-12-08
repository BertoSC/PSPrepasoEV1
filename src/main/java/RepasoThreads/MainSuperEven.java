package RepasoThreads;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.*;

public class MainSuperEven {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        Random rm = new Random();
        int limite1 = rm.nextInt(1, 10001);
        int limite2= rm.nextInt(1, 10001);

        int min = Math.min(limite1,limite2);
        int max = Math.max(limite1, limite2);

        ExecutorService pool = Executors.newFixedThreadPool(4);
        Set<Future> results = new HashSet<>();
        for (int i=min; i<=max; i++){
            Number num = new Number(i);
            CallableCheckSuperEven check = new CallableCheckSuperEven(num);
            results.add(pool.submit(check));
        }

        for (Future f: results) {
            Number res = (Number) f.get();
            if (res.getSuperEven()) {
                System.out.println(res.getNum() + " is super even");
            } else {
                System.out.println(res.getNum() + " is not super even");
            }
        }

        pool.shutdown();


    }
}
