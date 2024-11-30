package org.example;

import java.io.*;
import java.nio.file.Files;
import java.util.stream.Stream;

public class LaunchCoder {
    public static void main(String[] args) throws IOException {
       String [] command = {"java", "-cp", "target\\classes", "org.example.Coder"};
       File f = new File(args[0]);
       try (BufferedReader br = new BufferedReader(new FileReader(f))){
           String line;
           while ((line=br.readLine())!=null) {
               ProcessBuilder pb = new ProcessBuilder(command);
               Process process = pb.start();
               try (PrintWriter pw = new PrintWriter(process.getOutputStream())){
                   pw.println(line);
               }

               try (BufferedReader salida = new BufferedReader(new InputStreamReader(process.getInputStream()))){
                   String linea;
                   while ((linea=salida.readLine())!=null){
                       System.out.println(linea);
                   }
               }

           }
       }
    }
}
