package RepasoThreads;

import java.util.concurrent.Callable;

public class CallableMultipleEleven implements Callable<String> {
    String num;

    public CallableMultipleEleven(String num){
        this.num=num;
    }

    @Override
    public String call() throws Exception {
        int sumEven=0;
        int sumOdd=0;
        char[] number = num.toCharArray();

        for (int i=0; i<num.length(); i++){
            if (i%2==0){
                sumEven+=Character.getNumericValue(number[i]);
            } else{
                sumOdd+=Character.getNumericValue(number[i]);
            }
        }
        int difference = sumEven-sumOdd;

        if (difference%11==0){
            return num+" is multiple of 11";
        } else{
            return num+ " is not multiple of 11";
        }



    }
}
