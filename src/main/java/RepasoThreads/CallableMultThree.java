package RepasoThreads;

import java.util.concurrent.Callable;

public class CallableMultThree implements Callable<String> {
    String num;

    public CallableMultThree(String num){
        this.num=num;
    }
    @Override
    public String call() throws Exception {
        int sum=0;

        for (int i=0; i<num.length();i++){
            sum+=Character.getNumericValue(num.charAt(0));
        }

        if (sum%3==0){
            return num +" is multiple of 3";
        } else {
            return num+ " is not multiple of 3";
        }


    }
}
