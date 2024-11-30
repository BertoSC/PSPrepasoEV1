package org.example;

import java.io.*;
import java.nio.file.Files;
import java.sql.SQLOutput;
import java.util.Scanner;

public class LauncherEven {
    public static void main(String[] args) throws IOException, InterruptedException {

        String [] command = {"java", "-cp", "target\\classes", "org.example.Even"};
        //ESTO SI FUESE UN JAR  String [] command = {"java","-cp", "src/main/resources/BasicProject-1.0-SNAPSHOT.jar", "org.example.BirthdayArgs", "2", "2", "45"};
        ProcessBuilder pb = new ProcessBuilder(command);
        Process process = pb.start();
        String num1 = "0";
        String num2 = "8";

       try (PrintWriter pw = new PrintWriter(process.getOutputStream())){
           pw.write(num1);
           // mejor con pw.println(num1);
           pw.write(" ");
           pw.println(num2);
       }

       try (var in= new BufferedReader(new InputStreamReader(process.getInputStream()));
       var out = new BufferedWriter(new FileWriter("output.txt"))){
           String line;
           while ((line=in.readLine())!=null){
               System.out.println(line);
               out.write(line);
           }
       }

       int cod = process.waitFor();

       try (var in = new BufferedReader(new InputStreamReader(process.getErrorStream()));
            var out = new BufferedWriter(new FileWriter("error.txt"))){
           String errLine;
           while((errLine=in.readLine())!=null){
               out.write(errLine);
           }
           out.write(cod);
           if (cod==0) {
               out.write("Proceso ejecutado exitosamente");
           } else {
               out.write("Problemas");
           }

       }

    }
}
