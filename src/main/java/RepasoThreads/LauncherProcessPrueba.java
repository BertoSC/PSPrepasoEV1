package RepasoThreads;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class LauncherProcessPrueba {
    public static void main(String[] args) throws IOException, InterruptedException {
        String [] comando = { "java", "-cp", "target\\classes", "RepasoThreads.MainSuperEven"};

        ProcessBuilder pb = new ProcessBuilder(comando);
        pb.redirectOutput(new File("src/main/resources/even.txt"));


        Process process = pb.start();
        int code = process.waitFor();


        if (code==0){
            System.out.println("Proceso exitoso");
        } else {
            System.err.println("Error en el proceso");
        }

        try (var in= new BufferedReader(new FileReader("src/main/resources/even.txt"))){
            String contentLine;
            while ((contentLine=in.readLine())!=null){
                System.out.println(contentLine);
            }
        }



    }
}
