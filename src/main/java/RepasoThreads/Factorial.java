package RepasoThreads;

import java.util.Scanner;

public class Factorial {

    public static int calcularFactorial(int n){
        int factorial=1;

        for (int i=1; i<=n;i++){
            factorial*=i;
        }

        return factorial;

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int number = sc.nextInt();
        //int number= Character.getNumericValue(args[0].charAt(0));
        System.out.println(calcularFactorial(number));
    }
}
