import org.datavec.api.io.labels.ParentPathLabelGenerator;
import org.datavec.api.records.listener.impl.LogRecordListener;
import org.datavec.api.split.FileSplit;
import org.datavec.image.loader.NativeImageLoader;
import org.datavec.image.recordreader.ImageRecordReader;
import org.datavec.image.transform.ImageTransform;
import org.datavec.image.transform.ResizeImageTransform;
import org.deeplearning4j.datasets.datavec.RecordReaderDataSetIterator;
import org.nd4j.linalg.dataset.DataSet;
import org.nd4j.linalg.dataset.api.iterator.DataSetIterator;
import org.nd4j.linalg.dataset.api.preprocessor.DataNormalization;
import org.nd4j.linalg.dataset.api.preprocessor.ImagePreProcessingScaler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;
import java.util.Random;

/**
 * Created by Volker on 25.02.17.
 */
public class ImagePipeline2 {
    private static Logger log = LoggerFactory.getLogger(ImagePipeline2.class);
    //image information
    // size = XXX * XXX
    private static int height =1024;
    private static int width =768;
    // channels = red green blue
    private static int channels = 3;
    // seed for repeatable tests
    private static int rngseed = 123;
    private static int batchSize = 1;
    // number of possible labers
    private static int outputNum = 2;


    public static void main(String[] args) throws IOException {
        Random randNumGen = new Random(rngseed);

        File trainData = new File("/Users/Volker/automaticimagetagging/src/main/resources");

                //Define the filesplit(PATH, ALLOWED FORMATS, random
        FileSplit train = new FileSplit(trainData, NativeImageLoader.ALLOWED_FORMATS, randNumGen);

        //extract the labels from the directory
        ParentPathLabelGenerator labelMaker = new ParentPathLabelGenerator();
        // transform all images to same size
        ImageTransform imageTransformer = new ResizeImageTransform(height, width);

        ImageRecordReader recordReader = new ImageRecordReader(height, width, channels, labelMaker, imageTransformer);

        //Initialize the record reader
        // add a listener to extract the name

        recordReader.initialize(train);
        recordReader.setListeners(new LogRecordListener());

        // DataSet Iterator

        DataSetIterator dataIter = new RecordReaderDataSetIterator(recordReader, batchSize, 1, outputNum);


        // scale pixelvalues

        DataNormalization scaler = new ImagePreProcessingScaler(0,1);
        scaler.fit(dataIter);
        dataIter.setPreProcessor(scaler);

//        for (int i = 1; i<3; i++) {
//            DataSet ds = dataIter.next();
//            System.out.println(ds.getFeatureMatrix());
////            System.out.println(ds.getLabels());
//        }

        // showing the data as matrices with values between 0..1
        while (dataIter.hasNext()) {
            DataSet ds = dataIter.next();
            System.out.println(ds);
            try {
                Thread.sleep(3000);                 //1000 milliseconds is one second.
            } catch(InterruptedException ex) {
                Thread.currentThread().interrupt();
            }
        }
        recordReader.reset();




    }
}
