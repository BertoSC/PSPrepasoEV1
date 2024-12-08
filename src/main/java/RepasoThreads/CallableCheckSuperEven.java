package RepasoThreads;
import java.util.concurrent.*;

public class CallableCheckSuperEven implements Callable<Number> {
    Number num;
    ExecutorService pool;

    public CallableCheckSuperEven(Number num){
        this.num=num;
        this.pool=Executors.newFixedThreadPool(2);
    }

    @Override
    public Number call () throws ExecutionException, InterruptedException {

        char [] c= String.valueOf(num.getNum()).toCharArray();
        for (char ch:c){
            CallableCheckEven even = new CallableCheckEven(ch);
            Future<Boolean> fut = pool.submit(even);
            Boolean res = fut.get();
            if (!res){
                 num.setSuperEven(res);
            }
        }
        pool.shutdown();
        return num;
    }
}
