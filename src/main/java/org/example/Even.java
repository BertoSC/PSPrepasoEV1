package org.example;

import java.sql.SQLOutput;
import java.util.Scanner;

public class Even {

    public Even(){
        Scanner sc = new Scanner(System.in);
        int first = sc.nextInt();
        int second = sc.nextInt();

        StringBuilder sb = new StringBuilder();
        for (int i=first; i<=second; i++){
            if (i%2==0){
                sb.append(i);
            }
        }
        System.out.println(sb.toString());

    }

    public static void main(String[] args) {
        new Even();
    }
}
