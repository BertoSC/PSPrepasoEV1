package RepasoThreads;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.*;

public class MultipleMainLauncher {
    private final static int TOTAL_NUM=50;
    private final static int SECOND_POOL_SIZE=12;

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        ExecutorService poolNum = Executors.newSingleThreadExecutor();
        ExecutorService poolMultiple = Executors.newFixedThreadPool(SECOND_POOL_SIZE);
        Set<Future> numbers = new HashSet<>(TOTAL_NUM);
        Set<Future> results = new HashSet<>();

        for (int i =0; i< TOTAL_NUM;i++){
            CallableCreateNumber cal = new CallableCreateNumber();
            numbers.add(poolNum.submit(cal));
        }

        for (Future num: numbers) {
            CallableMultThree c1 = new CallableMultThree(num.get().toString());
            results.add(poolMultiple.submit(c1));

            CallableMulitpleFive c2 = new CallableMulitpleFive(num.get().toString());
            results.add(poolMultiple.submit(c2));

            CallableMultipleEleven c3 = new CallableMultipleEleven(num.get().toString());
            results.add(poolMultiple.submit(c3));

        }

        for (Future res: results) {
            System.out.println(res.get());
        }

        poolNum.shutdown();
        poolMultiple.shutdown();


    }

}
