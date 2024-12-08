package RepasoThreads;

import java.util.concurrent.Callable;

public class CallableCheckEven implements Callable<Boolean> {
    char n;

    public CallableCheckEven(char n){
        this.n=n;
    }
    @Override
    public Boolean call() throws Exception {
        return Character.getNumericValue(n)%2==0;
    }
}
