package org.example;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class TracertExample {
    public static void main(String[] args) {
        String[] command = {"cmd", "/c", "tracert", "www.pornhub.com"};

        ProcessBuilder pb = new ProcessBuilder(command);
        try {
            pb.redirectOutput(new File("prueba.txt"));
            Process process= pb.start();

           // esperamos 10 segudnos y lo destruimos
           Boolean finish= process.waitFor(10, TimeUnit.SECONDS);

           if (!finish){
               process.destroy();
           }

           /* int code= process.waitFor();
            if (code==0){
                System.out.println("SUCCESS OPERATION");
            } else{
                System.err.println("ERROR; ERROR");
            }
*/
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
