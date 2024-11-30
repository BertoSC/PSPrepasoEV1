package org.example;

import java.io.IOException;
import java.util.Scanner;

public class RuntimeComandos {
    public static void main(String[] args) throws InterruptedException {

        //String [] command = {"C:\\WINDOWS\\system32\\notepad.exe", "C:\\Users\\VSPC-BLACKFRIDAY\\Desktop\\prueba.txt"};
        String [] processKiller = {"cmd", "/c", "taskkill", "/F", "/PID","2840" };
        //  String [] comando = {"powershell", "Stop-Process -Id 2840"}; EN POWERCHELL
        Runtime run = Runtime.getRuntime();

        int processors = run.availableProcessors(); // devuelve el número de procesadores disponibles
        System.out.println("Procesadores disponibles "+processors);


        Process process;
        try {
            process = run.exec(processKiller);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        // Se espera a que el proceso finalice y obtenemos el código
        int cod= process.waitFor();
        if (cod==0){
            System.out.println("Operación exitosa");
        } else {
            System.err.println("Error");
        }

        // Con esto recuperamos el flujo de error y lo mostramos por consola en el programa
        if (cod != 0) {
            Scanner errorScanner = new Scanner(process.getErrorStream());
            String line;
            while (errorScanner.hasNextLine()) {
                System.out.println(errorScanner.nextLine());
            }
            errorScanner.close();
        }
    }
}