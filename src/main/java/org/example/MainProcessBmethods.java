package org.example;

import java.io.File;
import java.io.IOException;
import java.util.Map;
import java.util.Scanner;

public class MainProcessBmethods {
    public static void main(String[] args) {
       // Ejecutar un dir en el directorio introducido por el usuario mediante el método directory()

        //String [] command = {"cmd", "/c", "dir"};
       // Scanner sc = new Scanner(System.in);
        //System.out.println("Introduce a valid path:");
        //String path = sc.nextLine();
        String [] command = {"cmd", "/c", "echo", "%saludo%"};
        ProcessBuilder pb = new ProcessBuilder(command);
        //pb.directory(new File(path));

        Map <String, String> entorno = pb.environment();
        entorno.put("saludo", "Hello World");
        try {
            pb.inheritIO();
            pb.start();

          // for (Map.Entry<String, String> entry: entorno.entrySet()){
                //System.out.println(entry.getKey()+ " "+entry.getValue());
           //}

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        System.out.println();



    }
}
