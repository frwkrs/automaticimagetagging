import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * Created by Volker on 10.03.17.
 */
public class FetchImages {

    // Fetches CSV that contains image-urls & tags


    public static void createStringArrayFromCSV() throws IOException {

        String csvFile = "/Users/Volker/automaticimagetagging/src/main/resources/ExcelFile/image-attribute-tagging-DFE.csv";
        BufferedReader br = null;
        String line = "";
        String cvsSplitBy = ",";


        br = new BufferedReader(new FileReader(csvFile));


        while ((line = br.readLine()) != null) {
            // use comma as separator, stores one row of the csv in the String-array imageInformation
            String[] imageInformation = line.split(cvsSplitBy);

            for (String s : imageInformation) {
                System.out.println(s);
            }


        }

    }
}




/*
try(InputStream in = new URL("http://example.com/image.jpg").openStream()){
Files.copy(in, Paths.get("C:/File/To/Save/To/image.jpg"));
}
or this

try(InputStream in = new URL("http://example.com/image.jpg").openStream()){
Files.copy(in, Paths.get("C:/File/To/Save/To/image.jpg"));
}

Image image = null;
public static void fetchImages() throws MalformedURLException {
try {
URL url = new URL("http://www.google.de");
} catch ( IOException e ) {}


} */