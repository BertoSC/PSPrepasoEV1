package RepasoThreads;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MainDownloader {

    // ALGUNOS LINKS YA NO ESTÁN OPERATIVOS

    public static void main(String[] args) {
        File f = new File("src/main/resources/links.txt");
        ExecutorService pool = Executors.newSingleThreadExecutor();
        int counter=1;
        try {
            List<String> links = Files.readAllLines(f.toPath());
            for (String s: links){
                RunnableDownloader rd = new RunnableDownloader(s, counter);
                counter++;
                pool.execute(rd);
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        pool.shutdown();


    }
}
