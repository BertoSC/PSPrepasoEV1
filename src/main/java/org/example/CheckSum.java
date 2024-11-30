package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CheckSum {
    public static void main(String[] args) throws IOException, InterruptedException {
        String [] command = {"cmd", "/c", "certutil", "-hashfile", "pom.xml", "MD5"};

        ProcessBuilder pb = new ProcessBuilder(command);

        Process process = pb.start();

        // se recupera la salida del proceso para sacarlo por consola
        // también se recupera la salida de errores para imprimirlos

        try(var in = new BufferedReader(new InputStreamReader(process.getInputStream()));
        var err = new BufferedReader(new InputStreamReader(process.getErrorStream()))){
            String line;
            String errore;
            while ((line=in.readLine())!=null){
                System.out.println(line);
            }

            while ((errore=in.readLine())!= null){
                System.err.println(errore);
            }
        }

        int code = process.waitFor();

        if (code==0){
            System.out.println("EXECUTION SUCCESSFULLY");
        } else {
            System.err.println("UPS");
        }

    }
}
