package RepasoThreads;

public class RunnableSumTemperature implements Runnable{
    int [] actualYear;
    int sum;

    public RunnableSumTemperature(int [] year){
        this.actualYear=year;
    }

    public int getSum() {
        return sum;
    }

    @Override
    public void run() {
        for (int i=0; i<actualYear.length;i++){
            sum+=actualYear[i];
        }

    }
}
