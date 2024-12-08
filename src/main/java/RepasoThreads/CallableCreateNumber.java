package RepasoThreads;

import java.util.Random;
import java.util.concurrent.Callable;

public class CallableCreateNumber implements Callable<String> {
    private final static int MIN_SIZE = 20;
    private final static int MAX_SIZE = 51;
    private final static int MIN_VALUE=1;
    private final static int MAX_VALUE=10;

    @Override
    public String call() throws Exception {
        StringBuilder sb = new StringBuilder();
        Random rm = new Random();
        int size = rm.nextInt(20, 51);
        for (int i=0; i<size;i++){
            sb.append(String.valueOf(rm.nextInt(MIN_VALUE, MAX_VALUE)));
        }
        return sb.toString();
    }
}
