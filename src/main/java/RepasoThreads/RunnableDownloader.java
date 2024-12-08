package RepasoThreads;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.*;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;

public class RunnableDownloader implements Runnable {
    String url= "src/main/resources/";
    String link;
    int counter;

    public RunnableDownloader(String f, int count){
        this.link = f;
        this.counter=count;
    }

    // VERSIÓN SIN IMAGE IO
    @Override
    public void run() {
        URI enlace = null;
        try {
            enlace = new URI(link);
            File destino = new File(url+"animal"+counter+".jpg");
            try (var in = new BufferedInputStream(enlace.toURL().openStream());
                 var out = new FileOutputStream(destino)) {
                byte [] buffer = new byte[1024];
                int bytesReaded;
                while ((bytesReaded=in.read(buffer))!=-1){
                    out.write(buffer, 0,bytesReaded);
                }


            } catch (MalformedURLException e) {
                throw new RuntimeException(e);
            } catch (IOException e) {
                throw new RuntimeException(e);

            }
        } catch (URISyntaxException e) {
            throw new RuntimeException(e);
        }
    }

/*   // VERSIÓN CON IMAGE IO

    @Override
    public void run() {
        try {
            BufferedImage img = ImageIO.read(new URI(link).toURL());
            File destino = new File(url+"image"+counter+".jpg");
            ImageIO.write(img, "jpg", destino);

        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (URISyntaxException e) {
            throw new RuntimeException(e);
        }
    }

 */
}