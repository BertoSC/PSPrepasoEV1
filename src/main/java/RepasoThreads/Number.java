package RepasoThreads;

import java.util.concurrent.atomic.AtomicBoolean;

public class Number {
    private int num;
    AtomicBoolean superEven= new AtomicBoolean(true);

    public Number(int num){
        this.num=num;
    }

    public int getNum() {
        return num;
    }

    public Boolean getSuperEven() {
        return superEven.get();
    }

    public void setNum(int num) {
        this.num = num;
    }

    public Boolean setSuperEven(Boolean isSupEv) {
        return this.superEven.getAndSet(isSupEv);
    }
}
