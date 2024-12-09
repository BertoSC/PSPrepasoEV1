package RepasoThreads;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class NumeroCuriosoMain {
    public static void main(String[] args) throws IOException {

        List<Integer> numberList = new ArrayList<>();
/*
        Random rm = new Random();
        int size = rm.nextInt(1, 100);
        for (int i =0; i<size; i++){
            numberList.add(rm.nextInt(20, 400));
        }
*/
        List <String> numbers = Files.readAllLines(Paths.get("numeroscuriosos.txt"));

        for (String num: numbers){
            int number= Integer.parseInt(num);
            System.out.println("Comprobando si "+number+" es un numero curioso");
            String s = String.valueOf(number);
            int factorialSum =0;

            for (int j=0; j<s.length();j++){

                String letra = String.valueOf(s.charAt(j));
                String [] comando = {"java", "-cp", "target\\classes", "RepasoThreads.Factorial"};
                ProcessBuilder pb = new ProcessBuilder(comando);
                Process process = pb.start();

                try (var out = new PrintWriter(process.getOutputStream())){
                    out.println(letra);
                }

                try (var in = new BufferedReader(new InputStreamReader(process.getInputStream()))) {
                    String line;
                    while((line =in.readLine())!=null){
                        factorialSum += Integer.parseInt(line);
                    }

            }

            if (number!= factorialSum){
                System.out.println(number+ " no es numero curioso");
            } else {
                System.out.println(number+ " es un numero curioso");
            }

        }
    }
}}
