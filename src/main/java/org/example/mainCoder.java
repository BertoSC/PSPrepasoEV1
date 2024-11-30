package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class mainCoder {
    public static void main(String[] args) throws IOException {
        String [] command = {"java", "-cp", "target\\classes", "org.example.LaunchCoder", "codificar.TXT"};

        ProcessBuilder pb = new ProcessBuilder(command);
        Process process = pb.start();
        try (BufferedReader salida = new BufferedReader(new InputStreamReader(process.getInputStream()))){
            String linea;

            while ((linea=salida.readLine())!=null){
                System.out.println(linea);
            }
        }
    }
}
