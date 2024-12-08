package RepasoThreads;

import java.util.concurrent.Callable;

public class CallableMulitpleFive implements Callable<String> {
    String num;

    public CallableMulitpleFive(String num){
        this.num=num;
    }
    @Override
    public String call() throws Exception {

        char lastLetter = num.toCharArray()[num.length()-1];
        if (Character.getNumericValue(lastLetter)==5|| Character.getNumericValue(lastLetter)==0){
            return num+ " is multiple of 5";
        } else {
            return num + " is not multiple of 5";
        }
    }
}
