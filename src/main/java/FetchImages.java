import java.awt.*;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by Volker on 10.03.17.
 */
public class FetchImages {

//    try(InputStream in = new URL("http://example.com/image.jpg").openStream()){
//        Files.copy(in, Paths.get("C:/File/To/Save/To/image.jpg"));
//    }

    // or this

    Image image = null;
    public static void fetchImages() throws MalformedURLException {
        try {
            URL url = new URL("http://www.google.de");
        } catch ( IOException e ) {}


    }
}
